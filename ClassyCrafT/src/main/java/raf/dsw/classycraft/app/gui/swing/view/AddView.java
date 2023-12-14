package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.controller.action.NewDiagramAction;
import raf.dsw.classycraft.app.gui.swing.controller.action.NewPackageAction;
import raf.dsw.classycraft.app.gui.swing.controller.stateAction.AddClassAction;
import raf.dsw.classycraft.app.gui.swing.controller.stateAction.AddEnumAction;
import raf.dsw.classycraft.app.gui.swing.controller.stateAction.AddInterfaceAction;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTree;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImpl;

import javax.swing.*;
import java.awt.*;

public class AddView extends JFrame {
    private JButton bt1;
    private JButton bt2;
    private JButton bt3;
    private ActionManager actionManager;

    private JLabel tekst;
    public AddView(){
        initialise();
    }

    private void initialise()
    {
        actionManager = new ActionManager();
        initialiseGui();
    }

    private void initialiseGui(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setTitle("Add inter class");

        tekst = new JLabel("Sta zelite da dodate na dijagram: ");
        bt1 = new JButton();
        bt1.setAction(new AddClassAction());
        bt2 = new JButton();
        bt2.setAction(new AddInterfaceAction());
        bt3 = new JButton();
        bt3.setAction(new AddEnumAction());
        bt1.setText("Class");
        bt2.setText("Interface");
        bt3.setText("Enum");
        JPanel panel = new JPanel();
        this.setSize(500, 70);
        panel.add(tekst);
        panel.add(bt1);
        panel.add(bt2);
        panel.add(bt3);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        this.add(panel);

        panel.setVisible(true);

    }
}
