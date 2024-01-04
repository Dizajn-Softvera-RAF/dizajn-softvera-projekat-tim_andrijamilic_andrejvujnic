//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package raf.dsw.classycraft.app.gui.swing.painter.interClassPainter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.classContet.ClassContent;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;

public class KlasaPainter extends InterClassPainter {
    public KlasaPainter(DiagramElement element) {
        super(element);
    }

    public void paint(Graphics2D g) {
        g.setStroke(new BasicStroke((float)this.getDiagramElement().getStroke()));
        Klasa k = (Klasa)this.getDiagramElement();
        String name = k.getName();
        this.setShape(new Rectangle2D.Double(k.getPosition().getX(), k.getPosition().getY(), 50.0, 50.0));
        g.setPaint(Color.LIGHT_GRAY);
        g.fill(this.getShape());
        g.setStroke(new BasicStroke(2.0F));
        if (this.isSelected()) {
            g.setPaint(Color.BLACK);
        } else {
            g.setPaint(k.getBoja());
        }

        g.setFont(new Font("Arial", 1, 10));
        int b = 10;

        for(Iterator var5 = k.getKontent().iterator(); var5.hasNext(); b += 10) {
            ClassContent cc = (ClassContent)var5.next();
            String a = cc.toString();
            g.drawString(a, (int)k.getPosition().getX(), (int)k.getPosition().getY() + b);
        }

        g.drawString(name, (int)k.getPosition().getX(), (int)k.getPosition().getY());
        g.draw(this.getShape());
    }

    public boolean elementAt(Point pos) {
        return false;
    }
}
