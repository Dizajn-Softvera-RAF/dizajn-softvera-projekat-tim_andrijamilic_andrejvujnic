package raf.dsw.classycraft.app.gui.swing.controller.stateAction;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddClassAction extends AbstractClassyAction {

    public AddClassAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "Add inter class");
        putValue(SHORT_DESCRIPTION, "Add inter class");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //((PackageView) MainFrame.getInstance().getSplit().getRightComponent()).startAddClassState();
        MainFrame.getInstance().getPackageView().startAddClassState();
    }
}
