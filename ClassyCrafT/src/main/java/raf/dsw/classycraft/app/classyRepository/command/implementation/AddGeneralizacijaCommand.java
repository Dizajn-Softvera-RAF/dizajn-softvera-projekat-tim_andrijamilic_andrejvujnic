package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Agregacija;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Generalizacija;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.AgregacijaPainter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.GeneralizacijaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;

public class AddGeneralizacijaCommand extends AbstractCommand {
    private DiagramView dw;
    private Point point;
    private Painter from;
    private Painter to;
    private Generalizacija generalizacija;
    private GeneralizacijaPainter gp;

    public AddGeneralizacijaCommand(DiagramView diagramView, Point point, Painter from, Painter to) {
        this.dw = diagramView;
        this.point = point;
        this.from = from;
        this.to = to;
    }
    @Override
    public void doCommand() {
        Generalizacija con = new Generalizacija("Generalizacija", dw.getDiagram(), (InterClass) from.getDiagramElement(), (InterClass) to.getDiagramElement());
        generalizacija =  con;
        dw.getDiagram().addChild(con);
        gp = new GeneralizacijaPainter(generalizacija);
        dw.getPainters().add(gp);

    }

    @Override
    public void undoCommand() {
        dw.getDiagram().removeChild(generalizacija);
        dw.getPainters().remove(gp);
        dw.repaint();
    }
}
