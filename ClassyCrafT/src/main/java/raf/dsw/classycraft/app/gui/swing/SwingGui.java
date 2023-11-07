package raf.dsw.classycraft.app.gui.swing;

import raf.dsw.classycraft.app.core.Gui;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

public class SwingGui implements Gui {

    private MainFrame instance;

    public SwingGui(){

    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }

}
