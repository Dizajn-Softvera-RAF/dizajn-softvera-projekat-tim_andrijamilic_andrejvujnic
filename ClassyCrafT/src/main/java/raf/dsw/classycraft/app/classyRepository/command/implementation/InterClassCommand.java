package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;

public class InterClassCommand extends AbstractCommand {

    private Diagram diagram;
    private InterClass interClass;

    public InterClassCommand(Diagram diagram, InterClass interClass) {
        this.diagram = diagram;
        this.interClass = interClass;
    }
    @Override
    public void doCommand() {
        diagram.addModel(interClass);
    }

    @Override
    public void undoCommand() {

    }
}
