package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;

public class PackageToolBar extends JToolBar {
    public PackageToolBar(){
        super(HORIZONTAL);
        setFloatable(false);
        //add((PackageView)MainFrame.getInstance().getSplit().getRightComponent()).getStateManager().getAddClassState());
        //add(MainFrame.getInstance().getActionManager().getAddClassState());
        add(MainFrame.getInstance().getActionManager().getAddClassAction());
        add(MainFrame.getInstance().getActionManager().getMoveAction());


    }
}
