package raf.dsw.classycraft.app.classyRepository.command;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class CommandManager {
    private List<AbstractCommand> komande = new ArrayList<>();
    private int currentCommand = 0;


    public void addCommand(AbstractCommand command){
        while(currentCommand < komande.size()){
            komande.remove(currentCommand);
        }
        komande.add(command);
        doCommand();
    }

    public void doCommand(){
        if(currentCommand < komande.size())
        {
            komande.get(currentCommand++).doCommand();
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getClassyTree().getTreeView());
            ApplicationFramework.getInstance().getGui().enableUndoAction();

        }
        if(currentCommand==komande.size()){
            ApplicationFramework.getInstance().getGui().disableRedoAction();
        }
    }

    public void undoCommand(){
        if(currentCommand > 0){
            komande.get(--currentCommand).undoCommand();
            ApplicationFramework.getInstance().getGui().enableRedoAction();
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getClassyTree().getTreeView());
        }
        if(currentCommand==0){
            ApplicationFramework.getInstance().getGui().disableUndoAction();
        }
    }
}
