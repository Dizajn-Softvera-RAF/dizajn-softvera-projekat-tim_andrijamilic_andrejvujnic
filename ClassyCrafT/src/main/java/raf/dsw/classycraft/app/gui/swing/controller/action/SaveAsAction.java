package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.messanger.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveAsAction extends AbstractClassyAction {

    public SaveAsAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/saveas.png"));
        putValue(NAME, "Save as");
        putValue(SHORT_DESCRIPTION, "Save as");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        Project project = getProjectToSave();

        if (project == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage("Projekat koji zelite da sacuvate mora bili otvoren ili selektovan u Project Explorer-u", MessageType.ERROR);
            return;
        }

        fileChooser.setSelectedFile(new File(project.getName() + ".json"));

        if (fileChooser.showSaveDialog(MainFrame.getInstance()) != JFileChooser.APPROVE_OPTION) return;

        File projectFile = fileChooser.getSelectedFile();
        project.setFilePath(projectFile.getPath());

        // ako projekat nije sacuvan u json formatu, automatski ga tako sacuvati
        if (!project.getFilePath().endsWith(".json")) {
            project.setFilePath(project.getFilePath() + ".json");
        }

        ApplicationFramework.getInstance().getSerializer().saveProject(project);

    }
}
