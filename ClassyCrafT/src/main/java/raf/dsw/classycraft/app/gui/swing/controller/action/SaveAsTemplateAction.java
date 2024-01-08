package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.messanger.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveAsTemplateAction extends AbstractClassyAction {
    public SaveAsTemplateAction() {
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(NAME, "Save as template");
        putValue(SHORT_DESCRIPTION, "Save a template");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/ClassyCraft/src/main/resources/templates");

        Diagram diagram = getDiagramToSave();

        if (diagram == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage("Morate otvoriti tab dijagrama koji zelite da sacuvate kao sablon, ili da izaberete taj diagram iz Project Explorer-a", MessageType.ERROR);
            return;
        }

        fileChooser.setSelectedFile(new File(diagram.getName() + ".json"));
        diagram.setTemplate(true);

        if (fileChooser.showSaveDialog(MainFrame.getInstance()) != JFileChooser.APPROVE_OPTION) return;

        File projectFile = fileChooser.getSelectedFile();

        String projectPath = projectFile.getPath();
        if (!projectPath.endsWith(".json")) projectPath = projectPath.concat(".json");

        ApplicationFramework.getInstance().getSerializer().saveTemplate(diagram, projectPath);
    }
}
