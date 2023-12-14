package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.state.State;

import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

public class ZoomState implements State {
    @Override
    public void misKliknut(int x, int y, DiagramView dw, MouseEvent event) {
        System.out.println("zoom");
        System.out.println(event.getButton());
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
    public void desniKlik(int x, int y, DiagramView dw) {

    }

    @Override
    public void misOtpusten(int x, int y, DiagramView dw) {

    }

    @Override
    public void misPovucen(int x, int y, DiagramView dw) {

    }
}
