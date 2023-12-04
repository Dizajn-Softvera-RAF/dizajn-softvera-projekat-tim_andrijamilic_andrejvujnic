package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class DiagramView extends JPanel {

    public DiagramView()
    {
        initialise();
    }
    private void initialise()
    {
        initialiseGui();
    }

    private void initialiseGui(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setSize(screenWidth / 2, screenHeight / 2);
        this.setSize(450,350);

        JLabel l1 = new JLabel("Andrija Milić");
        JLabel l2 = new JLabel("Andrej Vujnić");

        this.add(l1);
        this.add(l2);


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }
}
