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

    public AddClassCommand(DiagramView diagramView, Point point, Klasa klasa) {
        this.dw = diagramView;
        this.point = point;
        diagramElement = klasa;
    }
    @Override
    public void doCommand() {
        KlasaPainter kp = new KlasaPainter(diagramElement);
        dw.getDiagram().addChild(diagramElement);
        dw.getPainters().add(kp);
        diagramElement.setPainter(kp);
    }

    @Override
    public void undoCommand() {
        dw.getDiagram().removeChild(diagramElement);
        dw.getPainters().remove(diagramElement.getPainter());
        dw.repaint();

    }
}
