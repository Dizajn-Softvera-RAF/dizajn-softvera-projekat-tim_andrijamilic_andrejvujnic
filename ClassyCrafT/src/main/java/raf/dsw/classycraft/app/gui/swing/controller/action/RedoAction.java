package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractClassyAction {

    public RedoAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/redo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //MainFrame.getInstance().getPackageView().getDiagramView().getDiagram().getCommandManager().doCommand();
        ApplicationFramework.getInstance().getGui().getCommandManager().doCommand();
    }
}