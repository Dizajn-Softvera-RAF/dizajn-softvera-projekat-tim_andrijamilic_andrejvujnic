package raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;

import java.awt.*;
@Getter
@Setter
public abstract class InterClass extends DiagramElement {
    private boolean vidljivost;
    private String naziv;
    private Color boja;
    private Point position;

    public InterClass(String name, ClassyNode parent, Point position) {

        super(name, parent);
        this.position = position;
    }
}
