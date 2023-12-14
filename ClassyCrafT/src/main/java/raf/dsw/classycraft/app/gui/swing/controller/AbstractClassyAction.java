package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public abstract class AbstractClassyAction extends AbstractAction {

    public Icon loadIcon(String fileName){

        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        else {
            System.err.println("Resource not found: " + fileName);
        }
        return icon;
    }
    /*public void setActive(AbstractClassyAction action) {
        MainFrame.getInstance().getActionManager().getDeleteAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getAddClassAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getAddInterfaceAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getAddEnumAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getAddConnectionAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getMoveAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getSelectAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getZoomAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getEditAction().setEnabled(true);

        if (action == null) return;
        action.setEnabled(false);
    }*/
}
