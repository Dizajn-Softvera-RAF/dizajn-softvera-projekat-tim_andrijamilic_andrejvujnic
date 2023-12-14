package raf.dsw.classycraft.app.gui.swing.painter.interClassPainter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Enum;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Interface;

import java.awt.*;
import java.awt.geom.Rectangle2D;

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
        g.setPaint(Color.BLUE);

        g.fill(getShape());

        g.draw(getShape());
        if (isSelected()) g.setPaint(Color.YELLOW);
            else g.setPaint(e.getBoja());
    }

    @Override
    public boolean elementAt(DiagramElement element, Point pos) {
        return false;
    }
}
