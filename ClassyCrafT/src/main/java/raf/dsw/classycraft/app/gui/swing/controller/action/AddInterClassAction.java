package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.AddView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddInterClassAction extends AbstractClassyAction {

    public AddInterClassAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "Add inter class");
        putValue(SHORT_DESCRIPTION, "Add inter class");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        AddView addView = new AddView();
        addView.setVisible(true);
    }
}
