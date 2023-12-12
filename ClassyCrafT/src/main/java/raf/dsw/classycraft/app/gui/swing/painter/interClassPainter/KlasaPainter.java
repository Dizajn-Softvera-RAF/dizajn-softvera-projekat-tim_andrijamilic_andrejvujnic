package raf.dsw.classycraft.app.gui.swing.painter.interClassPainter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class KlasaPainter extends InterClassPainter{

    public KlasaPainter(DiagramElement element) {
        super(element);
        //System.out.println("KlasaPainter");
    }

    @Override
    public void paint(Graphics2D g) {
        //crtamo ovde
        //Rectangle2D.Float r = new Rectangle2D.Float(10.5f, 10.5f, 30.0f, 40.0f);
        System.out.println("paintereee");
    }

    @Override
    public boolean elementAt(DiagramElement element, Point pos) {
        return false;
    }
}
