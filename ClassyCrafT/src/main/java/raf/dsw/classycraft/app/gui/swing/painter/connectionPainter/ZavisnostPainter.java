package raf.dsw.classycraft.app.gui.swing.painter.connectionPainter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Generalizacija;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Zavisnost;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class ZavisnostPainter extends ConnectionPainter {

    public ZavisnostPainter(DiagramElement element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setStroke(new BasicStroke(this.getDiagramElement().getStroke()));
        Zavisnost ge = ((Zavisnost) getDiagramElement());
        Rectangle2D bounds= ge.getOd().getPainter().getShape().getBounds();
        Point fromPos = new Point((int) (bounds.getX() + bounds.getWidth() / 2), (int) (bounds.getY() + bounds.getHeight() / 2));
        bounds = ge.getDoo().getPainter().getShape().getBounds();
        Point toPos = new Point((int) (bounds.getX() + bounds.getWidth() / 2), (int) (bounds.getY() + bounds.getHeight() / 2));
        setShape(new Line2D.Double(fromPos.x, fromPos.y, toPos.x, toPos.y));
        g.setPaint(Color.RED);

        g.setStroke(new BasicStroke(2));

        if (isSelected())
            g.setPaint(Color.BLACK);
        else
            g.setPaint(ge.getBoja());

        g.draw(getShape());
    }

    @Override
    public boolean elementAt(Point pos) {
        return false;
    }
}
