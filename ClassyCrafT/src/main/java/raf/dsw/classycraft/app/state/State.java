package raf.dsw.classycraft.app.state;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.event.MouseEvent;

public interface State {
    public void misKliknut(int x, int y, DiagramView dw);
    public void misOtpusten(int x, int y, DiagramView dw);
    public void misPovucen(int x, int y, DiagramView dw);
}
