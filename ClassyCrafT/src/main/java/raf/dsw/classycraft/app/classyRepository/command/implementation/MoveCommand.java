package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Connection;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MoveCommand extends AbstractCommand {

    private DiagramView dw;
    private int startX;
    private int startY;
    private int x;
    private int y;
    private ArrayList<DiagramElement> selectedModels;

    public MoveCommand(DiagramView dw, int startX, int startY, int x, int y, ArrayList<DiagramElement> selectedModels) {
        this.dw = dw;
        this.startX = startX;
        this.startY = startY;
        this.x = x;
        this.y = y;
        this.selectedModels = selectedModels;
    }
    @Override
    public void doCommand() {
        ArrayList<Painter> selected = (ArrayList<Painter>) dw.getSelectedPainters();
        if(!selected.isEmpty()){
            for (Painter p: selected) {
                DiagramElement diagElem = p.getDiagramElement();
                if(!(diagElem instanceof InterClass)) continue;

                InterClass inter = (InterClass) diagElem;
                Point pos = inter.getPosition();

                int diff_x = x - startX;
                int diff_y = y - startY;

                inter.setPosition(new Point(pos.x + diff_x, pos.y + diff_y));
            }

        }else{
            updateSelectedPainters((ArrayList<Painter>) dw.getPainters(), x - startX, y - startY);
        }

        startX = x;
        startY = y;

        dw.repaint();
    }

    @Override
    public void undoCommand() {

    }

    public void updateSelectedPainters(ArrayList<Painter> painters, int adjustedX, int adjustedY) {
        for (Painter painter : painters) {
            if (painter instanceof ConnectionPainter) {
                continue;
            }
            InterClass o = (InterClass) painter.getDiagramElement();
            Point newPoint = new Point((int) (o.getPosition().getX() + adjustedX), (int) (o.getPosition().getY() + adjustedY));

            o.setPosition(newPoint);

            Rectangle2D rect = (Rectangle2D) painter.getShape();
            rect.setFrame(newPoint, rect.getBounds().getSize());

        }

    }



}
