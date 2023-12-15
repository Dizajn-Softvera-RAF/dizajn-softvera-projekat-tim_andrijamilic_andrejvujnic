package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;

public class PackageToolBar extends JToolBar {
    public PackageToolBar(){
        super(HORIZONTAL);
        setFloatable(false);
        add(MainFrame.getInstance().getActionManager().getAddInterClassAction());
        add(MainFrame.getInstance().getActionManager().getDeleteStateAction());
        add(MainFrame.getInstance().getActionManager().getAddConnectionAction());
        add(MainFrame.getInstance().getActionManager().getDuplicateAction());
        add(MainFrame.getInstance().getActionManager().getEditActionS());
        add(MainFrame.getInstance().getActionManager().getMoveAction());
        add(MainFrame.getInstance().getActionManager().getSelectAction());
        add(MainFrame.getInstance().getActionManager().getZoomAction());
    }
}
