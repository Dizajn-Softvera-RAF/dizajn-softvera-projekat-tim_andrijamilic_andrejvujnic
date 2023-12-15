package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.EditView;
import raf.dsw.classycraft.app.state.State;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EditState implements State {
    @Override
    public void misKliknut(int x, int y, DiagramView dw, MouseEvent event) {
        System.out.println("edit");
        EditView ed = new EditView();
        ArrayList<Painter> selected = (ArrayList<Painter>) dw.getSelectedPainters();
        for(Painter p : selected){
            ed.setVisible(true);
        }

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
