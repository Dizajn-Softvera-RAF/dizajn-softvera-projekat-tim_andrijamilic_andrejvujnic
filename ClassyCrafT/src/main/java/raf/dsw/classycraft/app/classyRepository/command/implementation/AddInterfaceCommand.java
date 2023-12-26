package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Interface;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.InterfejsPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.util.ArrayList;

public class AddInterfaceCommand extends AbstractCommand {

    private DiagramView dw;
    private Point point;
    private DiagramElement diagramElement;

    public AddInterfaceCommand(DiagramView diagramView, Point point) {
        this.dw = diagramView;
        this.point = point;
    }
    @Override
    public void doCommand() {
        Interface i = new Interface("Interface", dw.getDiagram(), new Point(point.x, point.y));
        InterfejsPainter ip = new InterfejsPainter(i);
        diagramElement = i;
        dw.getDiagram().addChild(i);
        dw.getPainters().add(ip);
        i.setPainter(ip);
    }

    @Override
    public void undoCommand() {
        dw.getDiagram().removeChild(diagramElement);
        dw.getPainters().remove(diagramElement.getPainter());
        dw.repaint();
    }
}
