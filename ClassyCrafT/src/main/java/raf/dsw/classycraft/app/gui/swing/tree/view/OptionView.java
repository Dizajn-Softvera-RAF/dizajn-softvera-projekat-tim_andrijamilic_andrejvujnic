package raf.dsw.classycraft.app.gui.swing.tree.view;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.controller.NewDiagramAction;
import raf.dsw.classycraft.app.gui.swing.controller.NewPackageAction;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTree;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImpl;
import raf.dsw.classycraft.app.gui.swing.view.MyMenyBar;
import raf.dsw.classycraft.app.gui.swing.view.MyToolBar;

import javax.swing.*;
import java.awt.*;

public class OptionView extends JFrame {
    private JButton bt1;
    private JButton bt2;
    private ClassyTree classyTree;
    private ActionManager actionManager;
    private JLabel tekst;


    public OptionView(){
        initialise();
    }

    private void initialise()
    {
        actionManager = new ActionManager();
        classyTree = new ClassyTreeImpl();
        initialiseGui();
    }

    private void initialiseGui(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setTitle("Option");

        tekst = new JLabel("Da li hocete da napravite novi paket ili diagram");
        bt1 = new JButton();
        bt1.setAction(new NewPackageAction());
        bt2 = new JButton();
        bt2.setAction(new NewDiagramAction());
        bt1.setText("Paket");
        bt2.setText("Diagram");
        JPanel panel = new JPanel();
        this.setSize(500, 70);
        panel.add(tekst);
        panel.add(bt1);
        panel.add(bt2);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        this.add(panel);

        panel.setVisible(true);

    }
}
