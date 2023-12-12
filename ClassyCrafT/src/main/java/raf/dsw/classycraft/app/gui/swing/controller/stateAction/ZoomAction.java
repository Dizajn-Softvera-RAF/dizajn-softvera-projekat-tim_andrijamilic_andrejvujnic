package raf.dsw.classycraft.app.gui.swing.controller.stateAction;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ZoomAction extends AbstractClassyAction {
    public ZoomAction()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/zoom.png"));
        putValue(NAME, "Zoom");
        putValue(SHORT_DESCRIPTION, "Zoom");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startZoomState();
    }
}
