package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.KlasaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;

public class AddClassCommand extends AbstractCommand {

    private DiagramView dw;
    private InterClass interClass;

    public AddClassCommand(DiagramView diagramView, InterClass interClass) {
        this.dw = diagramView;
        this.interClass = interClass;
    }
    @Override
    public void doCommand() {
        /*System.out.println("add do");
        Klasa k = new Klasa("Klasa", dw.getDiagram(), new Point(x, y));

        KlasaPainter kp = new KlasaPainter(k);
        dw.getDiagram().addChild(k);
        dw.getPainters().add(kp);
        k.setPainter(kp);*/
    }

    @Override
    public void undoCommand() {

    }
}
