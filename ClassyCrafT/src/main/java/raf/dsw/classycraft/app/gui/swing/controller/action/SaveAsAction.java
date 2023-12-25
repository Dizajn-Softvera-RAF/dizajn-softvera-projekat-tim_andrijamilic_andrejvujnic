package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;

import java.awt.event.ActionEvent;

public class SaveAsAction extends AbstractClassyAction {

    public SaveAsAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/saveas.png"));
        putValue(NAME, "Save as");
        putValue(SHORT_DESCRIPTION, "Save as");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
