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
    private int oldX;
    private int oldY;
    private int x;
    private int y;
    private ArrayList<DiagramElement> selectedModels;

    public MoveCommand(DiagramView dw, int x, int y, int startX, int startY, int oldX, int oldY) {
        this.dw = dw;
        this.startX = startX;
        this.startY = startY;
        this.x = x;
        this.y = y;
        this.oldY = oldY;
        this.oldX = oldX;
    }
    @Override
    public void doCommand() {
        updateSelectedPainters((ArrayList<Painter>) dw.getPainters(), x - startX, y - startY);
        dw.repaint();
    }

    @Override
    public void undoCommand() {
        ArrayList<Painter> selected = (ArrayList<Painter>) dw.getSelectedPainters();
        for(Painter p : selected){
            if (p instanceof ConnectionPainter) {
                continue;
            }
            InterClass o = (InterClass) p.getDiagramElement();
            Point newPoint = new Point( oldX, oldY);

            o.setPosition(newPoint);

            Rectangle2D rect = (Rectangle2D) p.getShape();
            rect.setFrame(newPoint, rect.getBounds().getSize());
        }
        dw.repaint();
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
