package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class SelectState implements State {

    private Rectangle2D selekcijaShape;
    private int startX;
    private int startY;
    @Override
    public void misKliknut(int x, int y, DiagramView dw, MouseEvent event) {


    }

    @Override
    public void misPritisnut(int x, int y, DiagramView dw) {
        System.out.println("select");
        selekcijaShape = new Rectangle2D.Double(x, y, 1 ,1);
        dw.setSelekcijaRect(selekcijaShape);
        startX = x;
        startY = y;
        checkSelection(dw);
    }




    @Override
    public void misOtpusten(int x, int y, DiagramView dw) {
        dw.setSelekcijaRect(new Rectangle2D.Double());
    }

    @Override
    public void misPovucen(int x, int y, DiagramView dw) {
        updateSelectionRect(dw, x, y);
        checkSelection(dw);
    }

    public void checkSelection(DiagramView dw) {
        dw.deselectAll();
        ArrayList<Painter> results = new ArrayList<>();
        for (Painter painter : dw.getPainters()) {
            if (dw.getSelekcijaRect().intersects(painter.getShape().getBounds())) {
                results.add(painter);
            }
        }

        if (results.isEmpty()) return;

        for (Painter selected : results) {
            dw.addSelectedPainter(selected);
        }
    }

    public void updateSelectionRect(DiagramView dw, int x, int y) {
        selekcijaShape.setFrameFromDiagonal(new Point(startX, startY), new Point(x, y));
        dw.setSelekcijaRect(selekcijaShape);
    }
}
