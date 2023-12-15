package raf.dsw.classycraft.app.gui.swing.controller.stateAction;

import com.sun.tools.javac.Main;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.AddConnectionView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

@Setter

public class AddAgregacijaAction extends AbstractClassyAction {


    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startAgregacijaState();
    }
}
