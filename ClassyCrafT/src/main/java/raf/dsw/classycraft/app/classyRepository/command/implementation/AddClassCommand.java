package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.KlasaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.util.ArrayList;

public class AddClassCommand extends AbstractCommand {

    private DiagramView dw;
    private Point point;
    private DiagramElement diagramElement;

    public AddClassCommand(DiagramView diagramView, Point point) {
        this.dw = diagramView;
        this.point = point;
    }
    @Override
    public void doCommand() {
        System.out.println("add do");
        Klasa k = new Klasa("Klasa", dw.getDiagram(), new Point(point.x, point.y));

        KlasaPainter kp = new KlasaPainter(k);
        diagramElement = k;
        dw.getDiagram().addChild(k);
        //System.out.println(dw.getDiagram().getChildren());
        dw.getPainters().add(kp);
        k.setPainter(kp);
    }

    @Override
    public void undoCommand() {
        dw.getDiagram().removeChild(diagramElement);
        dw.getPainters().remove(diagramElement.getPainter());
        dw.repaint();

    }
}
