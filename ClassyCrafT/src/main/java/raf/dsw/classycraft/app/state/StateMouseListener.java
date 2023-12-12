package raf.dsw.classycraft.app.state;

import com.sun.tools.javac.Main;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.state.concrete.AddClassState;
import raf.dsw.classycraft.app.state.concrete.MoveState;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class StateMouseListener extends MouseAdapter {

    private DiagramView dw;
    private static int cout = 1;

    //menjano
    public StateMouseListener(){
        dw = MainFrame.getInstance().getPackageView().getDiagramView();
        //dw = ((PackageView)MainFrame.getInstance().getSplit().getRightComponent()).getDiagramView();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(cout++);

        MainFrame.getInstance().getPackageView().misKliknut(e.getX(), e.getY(), dw);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
