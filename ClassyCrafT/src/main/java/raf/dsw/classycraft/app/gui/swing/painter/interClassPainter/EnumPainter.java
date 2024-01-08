package raf.dsw.classycraft.app.gui.swing.painter.interClassPainter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.classContet.ClassContent;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Enum;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Interface;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

public class EnumPainter extends InterClassPainter{
    public EnumPainter(DiagramElement element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setStroke(new BasicStroke(this.getDiagramElement().getStroke()));
        Enum e = ((Enum) getDiagramElement());
        String name = e.getName();
        setShape(new Rectangle2D.Double(e.getPosition().getX(), e.getPosition().getY(), 50, 50));
        g.setPaint(Color.CYAN);

        g.fill(getShape());

        g.setStroke(new BasicStroke(2));
        g.setPaint(Color.BLUE);

        if (isSelected())
            g.setPaint(Color.BLACK);
        else
            g.setPaint(e.getBoja());
        g.setFont(new Font("Arial", 1, 10));
        int b = 10;

        for(Iterator var5 = e.getKontent().iterator(); var5.hasNext(); b += 10) {
            String cc = (String) var5.next();
            String a = cc.toString();
            g.drawString(a, (int)e.getPosition().getX(), (int)e.getPosition().getY() + b);
        }

        g.drawString(name, (int)e.getPosition().getX(), (int)e.getPosition().getY());
        g.draw(getShape());

    }

    @Override
    public boolean elementAt(Point pos) {
        return false;
    }
}
