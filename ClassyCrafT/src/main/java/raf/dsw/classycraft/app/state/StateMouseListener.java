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
import java.awt.geom.Point2D;
import java.sql.SQLOutput;

public class StateMouseListener extends MouseAdapter {
    public StateMouseListener(){

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        MainFrame.getInstance().getPackageView().misKliknut(e.getX(), e.getY(), (DiagramView) e.getComponent(),e);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        MainFrame.getInstance().getPackageView().misPritisnut(e.getX(), e.getY(), (DiagramView) e.getComponent());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MainFrame.getInstance().getPackageView().misOtpusten(e.getX(), e.getY(), (DiagramView) e.getComponent());
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {
        MainFrame.getInstance().getPackageView().misPovucen(e.getX(), e.getY(), (DiagramView) e.getComponent());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
