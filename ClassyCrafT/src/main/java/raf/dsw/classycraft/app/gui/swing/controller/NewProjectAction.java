package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.OptionView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.messanger.Message;
import raf.dsw.classycraft.app.messanger.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.time.Instant;

public class NewProjectAction extends AbstractClassyAction {

    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClassyTreeItem selected = (ClassyTreeItem) MainFrame.getInstance().getClassyTree().getSelectedNode();

        if(selected == null)
        {
            ApplicationFramework.getInstance().getMessageGenerator().notifySubscriber(new Message(MessageType.WARNING, "Morate selektovati node za kreiranje", Timestamp.from(Instant.now())));

        }
        else if(!(selected.getClassyNode() instanceof Diagram)){
            if((selected.getClassyNode() instanceof Package)){
                OptionView p = new OptionView();
                p.setVisible(true);
            }else{
                MainFrame.getInstance().getClassyTree().addChild(selected, 0);
            }
        }
        else
        {
            ApplicationFramework.getInstance().getMessageGenerator().notifySubscriber(new Message(MessageType.WARNING, "Ne mozete kreirati node u dijagramu", Timestamp.from(Instant.now())));

        }

    }
}
