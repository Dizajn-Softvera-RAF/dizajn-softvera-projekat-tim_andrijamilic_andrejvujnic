package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.AddConnectionView;
import raf.dsw.classycraft.app.gui.swing.view.AddView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddConnectionAction extends AbstractClassyAction {

    public AddConnectionAction()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/veza.png"));
        putValue(NAME, "Add connection");
        putValue(SHORT_DESCRIPTION, "Add connection");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AddConnectionView addConnectionView = new AddConnectionView();
        addConnectionView.setVisible(true);
    }
}
