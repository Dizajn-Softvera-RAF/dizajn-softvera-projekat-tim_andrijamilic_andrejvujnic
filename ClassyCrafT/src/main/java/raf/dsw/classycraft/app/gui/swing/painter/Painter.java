package raf.dsw.classycraft.app.gui.swing.painter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;

import java.awt.*;

public abstract class Painter {

    public Painter(DiagramElement element) {	}
    public abstract void paint(Graphics2D g, DiagramElement element);

    public abstract boolean elementAt(DiagramElement element, Point pos);


}
