package raf.dsw.classycraft.app.gui.swing.controller;


import javax.swing.*;
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
        JLabel l=new JLabel("Andrija Milić  Andrej Vujnic");
        aboutUs.add(l);


        aboutUs.setVisible(true);
    }
}