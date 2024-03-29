package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.classyRepository.command.CommandManager;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.state.State;
import raf.dsw.classycraft.app.state.StateMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class DiagramView extends JPanel implements ISubscriber {

    private List<Painter> painters = new ArrayList<>();
    private CommandManager commandManager = new CommandManager();
    private List<Painter> selectedPainters = new ArrayList<>();
    private Rectangle2D selekcijaRect = new Rectangle2D.Double();
    private Diagram diagram;
    private State currentState;
    private AffineTransform transform = new AffineTransform();
    private static int count = 0;

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

    @Override
    public void update(Object notification) {
        this.repaint();

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(3, 0.8F));
        g2.transform(transform);
        for (Painter p : painters) {
            p.paint(g2);
        }
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1));
        Font font = new Font("Arial", 1, 20);
        g2.setFont(font);
        g2.setColor(Color.BLUE);

        g2.draw(selekcijaRect);
        g2.dispose();
        System.out.println("Izvršena paintComponent metoda view-a");
    }

    public void addSelectedPainter(Painter painter) {
        if (painter == null || selectedPainters.contains(painter)) return;
        painter.setSelected(true);
        selectedPainters.add(painter);
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

    public int getCount()
    {
        return ++count;
    }

}


