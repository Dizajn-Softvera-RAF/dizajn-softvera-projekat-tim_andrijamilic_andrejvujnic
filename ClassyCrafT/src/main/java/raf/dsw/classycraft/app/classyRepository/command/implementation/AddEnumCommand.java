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

    public AddEnumCommand(DiagramView diagramView, Point point) {
        this.dw = diagramView;
        this.point = point;
    }
    @Override
    public void doCommand() {
        Enum e = new Enum("Enum", dw.getDiagram(), new Point(point.x, point.y));
        EnumPainter ep = new EnumPainter(e);
        diagramElement = e;
        dw.getDiagram().addChild(e);
        dw.getPainters().add(ep);
        e.setPainter(ep);
    }

    @Override
    public void undoCommand() {
        dw.getDiagram().removeChild(diagramElement);
        dw.getPainters().remove(diagramElement.getPainter());
        dw.repaint();
    }
}
