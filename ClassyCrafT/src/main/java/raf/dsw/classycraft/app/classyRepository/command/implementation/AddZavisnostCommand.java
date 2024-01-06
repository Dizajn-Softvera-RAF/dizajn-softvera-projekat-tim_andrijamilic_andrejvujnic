package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Agregacija;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Zavisnost;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.AgregacijaPainter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.ZavisnostPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;

public class AddZavisnostCommand extends AbstractCommand {
    private DiagramView dw;
    private Point point;
    private Painter from;
    private Painter to;
    private Zavisnost zavisnost;
    private ZavisnostPainter zp;

    public AddZavisnostCommand(DiagramView diagramView, Point point, Painter from, Painter to) {
        this.dw = diagramView;
        this.point = point;
        this.from = from;
        this.to = to;
    }
    @Override
    public void doCommand() {
        Zavisnost con = new Zavisnost("Zavisnost", dw.getDiagram(), (InterClass) from.getDiagramElement(), (InterClass) to.getDiagramElement());
        zavisnost =  con;
        dw.getDiagram().addChild(con);
        zp = new ZavisnostPainter(zavisnost);
        dw.getPainters().add(zp);

    }

    @Override
    public void undoCommand() {
        dw.getDiagram().removeChild(zavisnost);
        dw.getPainters().remove(zp);
        dw.repaint();
    }
}
