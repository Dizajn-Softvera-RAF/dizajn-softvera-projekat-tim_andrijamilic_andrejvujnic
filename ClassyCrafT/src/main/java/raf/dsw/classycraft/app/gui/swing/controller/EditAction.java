package raf.dsw.classycraft.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractClassyAction{

    public EditAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
