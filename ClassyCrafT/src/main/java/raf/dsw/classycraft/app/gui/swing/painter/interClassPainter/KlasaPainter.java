package raf.dsw.classycraft.app.gui.swing.painter.interClassPainter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class KlasaPainter extends InterClassPainter{

    public KlasaPainter(DiagramElement element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D g) {

        g.setStroke(new BasicStroke(this.getDiagramElement().getStroke()));
        Klasa k = ((Klasa) getDiagramElement());
        String name = k.getName();
        setShape(new Rectangle2D.Double(k.getPosition().getX(), k.getPosition().getY(), 50, 50));
        g.setPaint(Color.RED);

        g.fill(getShape());

        g.draw(getShape());
    }

    @Override
    public boolean elementAt(DiagramElement element, Point pos) {
        return false;
    }
}
