package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.messanger.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class ExportAction extends AbstractClassyAction {
    public ExportAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/export.png"));
        putValue(NAME, "Export");
        putValue(SHORT_DESCRIPTION, "Export");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
