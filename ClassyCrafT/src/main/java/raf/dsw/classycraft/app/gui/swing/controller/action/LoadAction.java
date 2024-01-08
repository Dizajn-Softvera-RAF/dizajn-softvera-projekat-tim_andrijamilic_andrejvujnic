package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.AppCore;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.messanger.MessageType;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadAction extends AbstractClassyAction {

    public LoadAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/load.png"));
        putValue(NAME, "Load");
        putValue(SHORT_DESCRIPTION, "Load");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(".json", "json"));

        if (fileChooser.showOpenDialog(MainFrame.getInstance()) != JFileChooser.APPROVE_OPTION) return;

        try {
            File file = fileChooser.getSelectedFile();

            if (!file.getName().endsWith(".json")) {
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage("Projekat mora biti u JSON formatu", MessageType.ERROR);
                return;
            }

            Project p = ApplicationFramework.getInstance().getSerializer().loadProject(file);
            MainFrame.getInstance().getClassyTree().loadProject(p);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
