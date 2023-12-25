package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;

import java.awt.event.ActionEvent;

public class LoadAction extends AbstractClassyAction {

    public LoadAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/load.png"));
        putValue(NAME, "Load");
        putValue(SHORT_DESCRIPTION, "Load");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
