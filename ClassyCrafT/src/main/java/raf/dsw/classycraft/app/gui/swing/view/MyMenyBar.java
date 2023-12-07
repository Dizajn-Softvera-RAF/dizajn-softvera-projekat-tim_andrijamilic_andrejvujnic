package raf.dsw.classycraft.app.gui.swing.view;


import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenyBar extends JMenuBar {

    public MyMenyBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add((MainFrame.getInstance().getActionManager().getExitAction()));
        fileMenu.add((MainFrame.getInstance().getActionManager().getNewProjectAction()));
        fileMenu.add(MainFrame.getInstance().getActionManager().getEditAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteAction());

        JMenu help=new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        help.add(MainFrame.getInstance().getActionManager().getAboutUs());


        this.add(fileMenu);
        this.add(help);
    }

}
