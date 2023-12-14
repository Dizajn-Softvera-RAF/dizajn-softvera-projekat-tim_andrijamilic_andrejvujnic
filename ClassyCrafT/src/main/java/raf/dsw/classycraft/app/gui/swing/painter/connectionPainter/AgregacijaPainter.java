package raf.dsw.classycraft.app.gui.swing.painter.connectionPainter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;

import java.awt.*;

public class AgregacijaPainter extends ConnectionPainter {
    public AgregacijaPainter(DiagramElement element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D g) {

    }

    @Override
    public boolean elementAt(Point pos) {
        return false;
    }
}
