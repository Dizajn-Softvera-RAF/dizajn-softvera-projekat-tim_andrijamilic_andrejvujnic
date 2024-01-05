package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Agregacija;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.AgregacijaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.awt.geom.Rectangle2D;
public class AddAgregacijaCommand extends AbstractCommand {

    private DiagramView dw;
    private Point point;
    private Painter from;
    private Painter to;
    private Agregacija agregacija;
    private AgregacijaPainter ap;

    public AddAgregacijaCommand(DiagramView diagramView, Point point, Painter from, Painter to) {
        this.dw = diagramView;
        this.point = point;
        this.from = from;
        this.to = to;
    }
    @Override
    public void doCommand() {
        Agregacija con = new Agregacija("connection1", dw.getDiagram(), (InterClass) from.getDiagramElement(), (InterClass) to.getDiagramElement());
        agregacija =  con;
        dw.getDiagram().addChild(con);
        ap = new AgregacijaPainter(agregacija);
        dw.getPainters().add(ap);

    }

    @Override
    public void undoCommand() {
        dw.getDiagram().removeChild(agregacija);
        dw.getPainters().remove(ap);
        dw.repaint();
    }
}
