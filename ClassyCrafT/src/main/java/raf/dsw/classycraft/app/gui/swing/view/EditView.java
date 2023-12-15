package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.controller.action.NewDiagramAction;
import raf.dsw.classycraft.app.gui.swing.controller.action.NewPackageAction;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTree;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImpl;

import javax.swing.*;
import java.awt.*;

public class EditView extends JFrame {
    private JButton bt1;
    private JButton bt2;
    private ClassyTree classyTree;
    private ActionManager actionManager;
    private JLabel tekst;


    public EditView(){
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

        tekst = new JLabel("Edit je otvoren");
        bt1 = new JButton();
        //bt1.setAction(new NewPackageAction());
        bt2 = new JButton();
        //bt2.setAction(new NewDiagramAction());
        bt1.setText("Obrisi");
        bt2.setText("Dodaj");
        JPanel panel = new JPanel();
        this.setSize(500, 500);
        panel.add(tekst);
        panel.add(bt1);
        panel.add(bt2);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        this.add(panel);

        panel.setVisible(true);

    }


}
