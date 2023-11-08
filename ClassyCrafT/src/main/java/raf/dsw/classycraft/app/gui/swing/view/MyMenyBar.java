package raf.dsw.classycraft.app.gui.swing.view;


import raf.dsw.classycraft.app.gui.swing.controller.ExitAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MyMenyBar extends JMenuBar {

    public MyMenyBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add((MainFrame.getInstance().getActionManager().getExitAction()));
        fileMenu.add((MainFrame.getInstance().getActionManager().getNewProjectAction()));
        fileMenu.add(MainFrame.getInstance().getActionManager().getEditAction());

        JMenu help=new JMenu("Edit");
        help.setMnemonic(KeyEvent.VK_H);
        help.add(MainFrame.getInstance().getActionManager().getAboutUs());


        this.add(fileMenu);
        this.add(help);
    }

}
