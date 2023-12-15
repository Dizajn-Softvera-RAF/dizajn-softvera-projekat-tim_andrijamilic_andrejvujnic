package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class ZoomState implements State {

    @Override
    public void misKliknut(int x, int y, DiagramView dw, MouseEvent event) {
        System.out.println("zoom");
        AffineTransform transf = dw.getTransform();

        if(event.getButton() == 1)
        {
            // zoom in
            transf.scale(1.1, 1.1);
        }
        else if(event.getButton() == 3)
        {
            // zoom out
            transf.scale(0.9, 0.9);
        }
        dw.repaint();
    }

    @Override
    public void misPritisnut(int x, int y, DiagramView dw) {

    }


    @Override
    public void misOtpusten(int x, int y, DiagramView dw) {

    }

    @Override
    public void misPovucen(int x, int y, DiagramView dw) {

    }

}
