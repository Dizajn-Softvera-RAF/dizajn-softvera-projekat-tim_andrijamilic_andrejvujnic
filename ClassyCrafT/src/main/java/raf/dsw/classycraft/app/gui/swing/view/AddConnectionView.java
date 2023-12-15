package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.controller.stateAction.*;

import javax.swing.*;
import java.awt.*;

public class AddConnectionView extends JFrame{
    private JButton bt1;
    private JButton bt2;
    private JButton bt3;
    private JButton bt4;
    private ActionManager actionManager;

    private JLabel tekst;
    public AddConnectionView(){
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
        setTitle("Add connection");

        tekst = new JLabel("Izaberite jednu od ponudjenih veza: ");
        bt1 = new JButton();
        bt1.setAction(new AddAgregacijaAction());
        bt2 = new JButton();
        bt2.setAction(new AddGeneralizacijaAction());
        bt3 = new JButton();
        bt3.setAction(new AddKompozicijaAction());
        bt4 = new JButton();
        bt4.setAction(new AddZavisnostAction());
        bt1.setText("Agregacija");
        bt2.setText("Generalizacija");
        bt3.setText("Kompozicija");
        bt4.setText("Zavisnost");
        JPanel panel = new JPanel();
        this.setSize(700, 70);
        panel.add(tekst);
        panel.add(bt1);
        panel.add(bt2);
        panel.add(bt3);
        panel.add(bt4);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        this.add(panel);

        panel.setVisible(true);

    }
}
