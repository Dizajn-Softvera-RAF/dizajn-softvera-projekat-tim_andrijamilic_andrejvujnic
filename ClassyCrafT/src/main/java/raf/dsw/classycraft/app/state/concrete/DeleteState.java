package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.state.State;

public class DeleteState implements State {
    @Override
    public void misKliknut(int x, int y, DiagramView dw) {
        System.out.println("delete");
    }

    @Override
    public void misOtpusten(int x, int y, DiagramView dw) {

    }

    @Override
    public void misPovucen(int x, int y, DiagramView dw) {

    }
}