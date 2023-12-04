package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.messanger.Message;
import raf.dsw.classycraft.app.messanger.MessageType;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeleteAction extends AbstractClassyAction{
    public DeleteAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ClassyTreeItem selected = (ClassyTreeItem) MainFrame.getInstance().getClassyTree().getSelectedNode();

        if(selected == null){
            ApplicationFramework.getInstance().getMessageGenerator().notifySubscriber(new Message(MessageType.WARNING, "Morate selektovati node za brisanje", Timestamp.from(Instant.now())));

        }else if((selected.getClassyNode() instanceof ProjectExplorer)){

            ApplicationFramework.getInstance().getMessageGenerator().notifySubscriber(new Message(MessageType.WARNING, "Project Explorer se ne moze obrisati", Timestamp.from(Instant.now())));
        }else{
            MainFrame.getInstance().getClassyTree().removeChild(selected);

        }


    }

}
