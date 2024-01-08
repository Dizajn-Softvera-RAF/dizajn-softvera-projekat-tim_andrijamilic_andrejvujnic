package raf.dsw.classycraft.app.gui.swing.painter.interClassPainter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.classContet.ClassContent;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.classContet.Metoda;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Interface;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

public class InterfejsPainter extends InterClassPainter{
    public InterfejsPainter(DiagramElement element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D g) {

        g.setStroke(new BasicStroke(this.getDiagramElement().getStroke()));
        Interface i = ((Interface) getDiagramElement());
        String name = i.getName();
        setShape(new Rectangle2D.Double(i.getPosition().getX(), i.getPosition().getY(), 50, 50));
        g.setPaint(Color.PINK);

        g.fill(getShape());

        g.setStroke(new BasicStroke(2));
        g.setPaint(Color.BLUE);

        if (isSelected())
            g.setPaint(Color.BLACK);
        else
            g.setPaint(i.getBoja());
        g.setFont(new Font("Arial", 1, 10));
        int b = 10;

        for(Iterator var5 = i.getKontent().iterator(); var5.hasNext(); b += 10) {
            Metoda cc = (Metoda) var5.next();
            String a = cc.toString();
            g.drawString(a, (int)i.getPosition().getX(), (int)i.getPosition().getY() + b);
        }

        g.drawString(name, (int)i.getPosition().getX(), (int)i.getPosition().getY());
        g.draw(getShape());


    }

    @Override
    public boolean elementAt(Point pos) {
        return false;
    }
}
