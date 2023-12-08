package raf.dsw.classycraft.app.gui.swing.painter.connectionPainter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;

import java.awt.*;

public class GeneralizacijaPainter extends ConnectionPainter{
    public GeneralizacijaPainter(DiagramElement element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D g) {

    }

    @Override
    public boolean elementAt(DiagramElement element, Point pos) {
        return false;
    }
}
