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
    private boolean selected;

    public Painter(DiagramElement diagramElement) {
        this.diagramElement = diagramElement;
    }

    public Painter(DiagramElement diagramElement, Shape shape) {
        this.diagramElement = diagramElement;
        this.shape = shape;
        this.selected = false;
    }
    public abstract void paint(Graphics2D g);

    public abstract boolean elementAt(Point pos);


}
