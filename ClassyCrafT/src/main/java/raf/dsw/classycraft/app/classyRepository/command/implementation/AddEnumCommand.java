package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Enum;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.EnumPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;

public class AddEnumCommand extends AbstractCommand {

    private DiagramView dw;
    private Point point;
    private DiagramElement diagramElement;

    public AddEnumCommand(DiagramView diagramView, Point point, Enum e) {
        this.dw = diagramView;
        this.point = point;
        diagramElement = e;
    }
    @Override
    public void doCommand() {
        EnumPainter ep = new EnumPainter(diagramElement);
        dw.getDiagram().addChild(diagramElement);
        dw.getPainters().add(ep);
        diagramElement.setPainter(ep);
    }

    @Override
    public void undoCommand() {
        dw.getDiagram().removeChild(diagramElement);
        dw.getPainters().remove(diagramElement.getPainter());
        dw.repaint();
    }
}
