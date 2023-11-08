package raf.dsw.classycraft.app.gui.swing.controller;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AboutUs extends AbstractClassyAction{

    public AboutUs(){
        putValue(NAME, "About us");
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        JFrame aboutUs=new JFrame();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        aboutUs.setSize(screenWidth / 2, screenHeight / 2);
        aboutUs.setLocationRelativeTo(null);
        aboutUs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutUs.setSize(300,300);

        aboutUs.setTitle("About us");
        JPanel panel = new JPanel(new BorderLayout());
        JLabel l1 = new JLabel("Andrija Milić");
        JLabel l2 = new JLabel("Andrej Vujnić");

        panel.add(l1);
        panel.add(l2);

        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        aboutUs.add(panel);

        aboutUs.setVisible(true);
    }
}