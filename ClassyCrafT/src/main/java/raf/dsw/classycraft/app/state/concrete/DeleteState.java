package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.InterClassPainter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.KlasaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DeleteState implements State {
    @Override
    public void misKliknut(int x, int y, DiagramView dw, MouseEvent event) {
        System.out.println("delete");
        //Painter selected = getPainterAtClickedLocation(dw, new Point(x, y));

        ArrayList<DiagramElement> l = getSelectedModels((ArrayList<Painter>) dw.getSelectedPainters());
        ArrayList<Painter> selected = (ArrayList<Painter>) dw.getSelectedPainters();

        for(Painter pe : selected)
        {
            dw.getPainters().remove(pe);
        }
        for(DiagramElement d : l )
        {
            dw.getDiagram().removeChild(d);
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
    public Painter getPainterAtClickedLocation(DiagramView dw, Point point) {
        for (Painter painter : dw.getPainters()) {
            if (painter.elementAt(point)) return painter;
        }

        return null;
    }

    public Painter getPojamPainterAtClickedLocation(DiagramView dw, Point point) {
        for (Painter painter : dw.getPainters()) {
            if (painter instanceof InterClassPainter && painter.elementAt(point)) return (InterClassPainter) painter;
        }

        return null;
    }
    public ArrayList<DiagramElement> getSelectedModels(ArrayList<Painter> selectedPainters) {

        ArrayList<DiagramElement> models = new ArrayList<>();

        for (Painter painter : selectedPainters) {
            models.add(painter.getDiagramElement());
        }

        return models;
    }


}
