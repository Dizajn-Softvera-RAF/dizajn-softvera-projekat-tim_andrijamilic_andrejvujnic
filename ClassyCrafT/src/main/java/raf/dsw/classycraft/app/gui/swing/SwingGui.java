package raf.dsw.classycraft.app.gui.swing;

import raf.dsw.classycraft.app.classyRepository.command.CommandManager;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.core.Gui;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.util.HashMap;

public class SwingGui implements Gui {

    private MainFrame instance;
    //private HashMap<Diagram, CommandManager> commandManager;
    private CommandManager commandManager;

    public SwingGui(){

    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        disableRedoAction();
        disableUndoAction();
        commandManager = new CommandManager();
        instance.setVisible(true);
    }

    @Override
    public void disableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
    }

    @Override
    public void disableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
    }

    @Override
    public void enableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
    }

    @Override
    public void enableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
    }

    @Override
    public CommandManager getCommandManager() {
        return commandManager;
    }

}
