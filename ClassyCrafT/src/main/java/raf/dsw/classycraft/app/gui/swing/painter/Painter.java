package raf.dsw.classycraft.app.gui.swing.painter;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;

import java.awt.*;
@Getter
@Setter
public abstract class Painter {
    private Shape shape;
    private DiagramElement diagramElement;
    public Painter(DiagramElement element) {
        this.diagramElement = element;
    }
    public abstract void paint(Graphics2D g);

    public abstract boolean elementAt(DiagramElement element, Point pos);


}
