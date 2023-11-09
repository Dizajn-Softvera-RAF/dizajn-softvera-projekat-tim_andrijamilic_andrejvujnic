package raf.dsw.classycraft.app.gui.swing.controller;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AboutUs extends AbstractClassyAction{

    public AboutUs(){
        putValue(NAME, "About us");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SHORT_DESCRIPTION, "About us");

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
        aboutUs.setSize(450,350);

        aboutUs.setTitle("About us");

        JPanel panel = new JPanel(new BorderLayout());
        JPanel desno = new JPanel(new BorderLayout());
        JPanel levo = new JPanel(new BorderLayout());

        panel.add(levo, BorderLayout.WEST);
        panel.add(desno, BorderLayout.CENTER);

        JLabel l1 = new JLabel("Andrija Milić");
        JLabel l2 = new JLabel("Andrej Vujnić");

        JLabel img1 = new JLabel();
        img1.setIcon(new ImageIcon(getClass().getResource("/images/andrija.jpeg")));
        JLabel img2 = new JLabel();
        img2.setIcon(new ImageIcon(getClass().getResource("/images/andrej.jpeg")));

        levo.add(l1);
        levo.add(img1);

        desno.add(l2);
        desno.add(img2);

        levo.setBorder(new EmptyBorder(10, 10, 10, 10));
        desno.setBorder(new EmptyBorder(10, 10, 10, 10));

        levo.setLayout(new BoxLayout(levo, BoxLayout.Y_AXIS));
        desno.setLayout(new BoxLayout(desno, BoxLayout.Y_AXIS));

        aboutUs.add(panel);

        aboutUs.setVisible(true);
    }
}