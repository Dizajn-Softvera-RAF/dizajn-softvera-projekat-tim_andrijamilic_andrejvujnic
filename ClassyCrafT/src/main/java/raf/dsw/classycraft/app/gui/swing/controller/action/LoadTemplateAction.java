package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
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
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/ClassyCraft/src/main/resources/templates");
        fileChooser.setFileFilter(new FileNameExtensionFilter(".json", "json"));

        Diagram diagram = getDiagramToSave();

       if (diagram == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage("Morate otvoriti tab u koju zelite da dodate sablon, ili da izaberete taj projekat iz Project Explorer-a", MessageType.ERROR);//menjanoA
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
        System.out.println("modeliiii");
        for (ClassyNode model : templateDiagram.getChildren()) {
            System.out.println("modeli " + model);
            diagram.addChild(model);
            //lista modela je null
        }
    }
}
