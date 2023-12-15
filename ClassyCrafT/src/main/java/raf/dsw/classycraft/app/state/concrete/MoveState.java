package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MoveState implements State {

    private int startX;
    private int startY;
    public MoveState(){
    }
    @Override
    public void misKliknut(int x, int y, DiagramView dw, MouseEvent event) {
        System.out.println("move");
    }

    @Override
    public void misPritisnut(int x, int y, DiagramView dw) {
        startX = x;
        startY = y;

    }



    @Override
    public void misOtpusten(int x, int y, DiagramView dw) {
        updateSelectedPainters((ArrayList<Painter>) dw.getPainters(), x - startX, y - startY);
    }

    @Override
    public void misPovucen(int x, int y, DiagramView dw) {

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