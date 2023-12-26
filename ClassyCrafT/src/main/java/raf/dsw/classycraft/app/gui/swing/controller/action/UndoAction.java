package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractClassyAction {

    public UndoAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        ((PackageView)(MainFrame.getInstance().getSplit().getRightComponent())).getDW().getCommandManager().undoCommand();
        //ApplicationFramework.getInstance().getGui().getCommandManager().undoCommand();
    }
}
