package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.state.StateMouseListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiagramView extends JPanel implements ISubscriber {

    private List<Painter> p = new ArrayList<>();
    private Diagram diagram;
    public DiagramView()
    {
        addMouseListener(new StateMouseListener());
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


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

    public void misKliknut(int x, int y, DiagramView dw){

    };

    public void setDiagram(Diagram diagram) {
        this.diagram = diagram;
        this.setName(diagram.getName());
    }

    public Diagram getDiagram() {
        return this.diagram;
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setComposite(AlphaComposite.getInstance(3, 0.8F));
        //Iterator<DiagramElement> it = DiagramView.this.diagram;

       /* while(it.hasNext()) {
            Klasa d = (Klasa) it.next();
            Painter painter = d.getPainter();
        }*/

        System.out.println("Izvršena paintComponent metoda view-a");
    }

    @Override
    public void update(Object notification) {

        this.repaint();
    }
}
