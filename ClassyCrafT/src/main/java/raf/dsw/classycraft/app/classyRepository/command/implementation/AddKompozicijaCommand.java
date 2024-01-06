package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Agregacija;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Kompozicija;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.AgregacijaPainter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.KompozicijaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;

public class AddKompozicijaCommand extends AbstractCommand {
    private DiagramView dw;
    private Point point;
    private Painter from;
    private Painter to;
    private Kompozicija kompozicija;
    private KompozicijaPainter kp;

    public AddKompozicijaCommand(DiagramView diagramView, Point point, Painter from, Painter to) {
        this.dw = diagramView;
        this.point = point;
        this.from = from;
        this.to = to;
    }
    @Override
    public void doCommand() {
        Kompozicija con = new Kompozicija("Kompozicija", dw.getDiagram(), (InterClass) from.getDiagramElement(), (InterClass) to.getDiagramElement());
        kompozicija =  con;
        dw.getDiagram().addChild(con);
        kp = new KompozicijaPainter(kompozicija);
        dw.getPainters().add(kp);

    }

    @Override
    public void undoCommand() {
        dw.getDiagram().removeChild(kompozicija);
        dw.getPainters().remove(kp);
        dw.repaint();
    }
}
