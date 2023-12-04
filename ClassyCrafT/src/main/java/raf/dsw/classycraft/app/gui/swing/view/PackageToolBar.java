package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;

public class PackageToolBar extends JToolBar {
    public PackageToolBar(){
        super(HORIZONTAL);
        setFloatable(false);
        add(MainFrame.getInstance().getActionManager().getExitAction());
        add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        add(MainFrame.getInstance().getActionManager().getEditAction());
        add(MainFrame.getInstance().getActionManager().getDeleteAction());
    }
}
