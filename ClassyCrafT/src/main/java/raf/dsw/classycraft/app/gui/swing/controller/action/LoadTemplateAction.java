package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.messanger.MessageType;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadTemplateAction extends AbstractClassyAction {
    public LoadTemplateAction() {
        putValue(SMALL_ICON, loadIcon("/images/load.png"));
        putValue(NAME, "Load template");
        putValue(SHORT_DESCRIPTION, "Load template");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(".json", "json"));

        Diagram diagram = getDiagramToSave();

        if (diagram == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage("Morate otvoriti tab mape u koju zelite da dodate sablon, ili da izaberete tu mapu iz Project Explorer-a", MessageType.ERROR);
            return;
        }

        if (fileChooser.showOpenDialog(MainFrame.getInstance()) != JFileChooser.APPROVE_OPTION) return;

        Diagram templateDiagram;
        try {
            File file = fileChooser.getSelectedFile();
            templateDiagram = ApplicationFramework.getInstance().getSerializer().loadTemplate(file);

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

        for (DiagramElement model : templateDiagram.getModels()) {
            diagram.addModel(model);
        }
    }
}
