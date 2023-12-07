package raf.dsw.classycraft.app.gui.swing.painter.interClassPainter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;

import java.awt.*;

public class KlasaPainter extends InterClassPainter{

    public KlasaPainter(DiagramElement element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D g, DiagramElement element) {

    }

    @Override
    public boolean elementAt(DiagramElement element, Point pos) {
        return false;
    }
}
