package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.KlasaPainter;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.state.State;
import raf.dsw.classycraft.app.state.StateMouseListener;
import raf.dsw.classycraft.app.state.concrete.AddClassState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Setter
@Getter
public class DiagramView extends JPanel implements ISubscriber {

    private List<Painter> painters = new ArrayList<>();
    private List<Painter> selectedPainters = new ArrayList<>();
    private Rectangle2D selekcijaRect = new Rectangle2D.Double();
    private Diagram diagram;
    private State currentState;
    private AffineTransform transform = new AffineTransform();

    public DiagramView(Diagram model)
    {
        currentState = getCurrentState();
        this.diagram = model;
        model.addSubscriber(this);
        addMouseListener(new StateMouseListener());
        addMouseMotionListener(new StateMouseListener());
        this.painters = new ArrayList<>();
        this.selectedPainters = new ArrayList<>();
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

    public void setDiagram(Diagram diagram) {
        this.diagram = diagram;
        this.setName(diagram.getName());
    }

    public Diagram getDiagram() {
        return this.diagram;
    }

    @Override
    public void update(Object notification) {
        this.repaint();

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(3, 0.8F));
        for (Painter p : painters) {
            p.paint(g2);
        }
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1));
        g2.draw(selekcijaRect);
        g2.dispose();
        System.out.println("Izvršena paintComponent metoda view-a");
    }

    public void addSelectedPainter(Painter painter) {
        if (painter == null || selectedPainters.contains(painter)) return;
        painter.setSelected(true);
        selectedPainters.add(painter);
    }

    public void deletePainterFromModel(DiagramElement model) {
        for (Painter painter : painters) {
            if (painter.getDiagramElement().equals(model)) {
                selectedPainters.remove(painter);
                painters.remove(painter);
                return;
            }

        }
    }

    public void deselectAll() {
        for (Painter painter : selectedPainters) {
            painter.setSelected(false);
        }
        selectedPainters.clear();
    }


    public void setSelekcijaRect(Rectangle2D selekcijaRect) {
        this.selekcijaRect = selekcijaRect;
        this.repaint();
    }

}


