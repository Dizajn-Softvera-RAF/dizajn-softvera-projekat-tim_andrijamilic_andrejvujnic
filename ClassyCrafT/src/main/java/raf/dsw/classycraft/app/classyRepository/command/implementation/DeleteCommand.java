package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Connection;

import java.util.ArrayList;
import java.util.List;

public class DeleteCommand extends AbstractCommand {

    private Diagram diagram;
    private ArrayList<DiagramElement> models;

    public DeleteCommand(Diagram diagram, ArrayList<DiagramElement> models) {
        this.diagram = diagram;
        this.models = models;
    }
    @Override
    public void doCommand() {

    }

    @Override
    public void undoCommand() {

    }
}
