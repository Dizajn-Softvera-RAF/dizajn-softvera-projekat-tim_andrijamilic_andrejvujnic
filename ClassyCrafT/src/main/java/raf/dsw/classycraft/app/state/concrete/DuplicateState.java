package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.EnumPainter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.InterClassPainter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.InterfejsPainter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.KlasaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DuplicateState implements State {
    int copyCounter = 1;
    @Override
    public void misKliknut(int x, int y, DiagramView dw, MouseEvent event) {
        /*System.out.println("duplicate");
        List<Painter> selected = dw.getSelectedPainters();
        for(Painter p : selected){
            DiagramElement diagElem = p.getDiagramElement();
            InterClass inter = (InterClass) diagElem;
            Point pos = inter.getPosition();

            inter.setPosition(new Point(pos.x , pos.y ));
            dw.getPainters().add(p);
        }
        dw.repaint();*/

        System.out.println("duplicate");
        List<Painter> selected = dw.getSelectedPainters();
        List<Painter> duplicatedPainters = new ArrayList<>();

        for (Painter p : selected) {
            DiagramElement diagElem = p.getDiagramElement();
            if (diagElem instanceof InterClass) {
                InterClass inter = (InterClass) diagElem;
                try {
                    InterClass duplicatedInter = (InterClass) inter.clone();

                    Point pos = inter.getPosition();
                    duplicatedInter.setPosition(new Point(pos.x + 30, pos.y + 30));

                    // Kreirate novu instancu konkretne podklase koja nasleđuje Painter
                    KlasaPainter k = new KlasaPainter(duplicatedInter);


                    duplicatedPainters.add(k);

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                    // Rukovanje izuzetkom po potrebi
                }
            }
        }

        dw.getPainters().addAll(duplicatedPainters);
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
