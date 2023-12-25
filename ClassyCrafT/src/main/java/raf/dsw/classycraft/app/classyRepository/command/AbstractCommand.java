package raf.dsw.classycraft.app.classyRepository.command;

public abstract class AbstractCommand {
    public abstract void doCommand();
    public abstract void undoCommand();
}
