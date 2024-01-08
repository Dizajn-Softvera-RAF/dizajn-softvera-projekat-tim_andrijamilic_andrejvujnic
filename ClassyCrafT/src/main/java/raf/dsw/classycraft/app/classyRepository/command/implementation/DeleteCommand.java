package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Connection;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.util.ArrayList;
import java.util.List;

public class DeleteCommand extends AbstractCommand {

    private DiagramView dw;
    private ArrayList<DiagramElement> models;

    public DeleteCommand(DiagramView dw, ArrayList<DiagramElement> models) {
        this.dw= dw;
        this.models = models;
    }
    @Override
    public void doCommand() {
        ArrayList<Painter> selected = (ArrayList<Painter>) dw.getSelectedPainters();

        for(Painter pe : selected)
        {
            dw.getPainters().remove(pe);
        }
        for(DiagramElement d : models )
        {
            dw.getDiagram().removeChild(d);
        }
        dw.repaint();
    }

    @Override
    public void undoCommand() {
        for(DiagramElement d : models )
        {
            dw.getDiagram().addChild(d);
            Painter p = d.getPainter();
            dw.getPainters().add(p);

        }

        dw.repaint();
    }

    public ArrayList<DiagramElement> getSelectedModels(ArrayList<Painter> selectedPainters) {

        ArrayList<DiagramElement> models = new ArrayList<>();

        for (Painter painter : selectedPainters) {
            models.add(painter.getDiagramElement());
        }

        return models;
    }
}
