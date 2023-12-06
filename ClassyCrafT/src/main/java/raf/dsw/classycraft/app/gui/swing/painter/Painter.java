package raf.dsw.classycraft.app.gui.swing.painter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;

import java.awt.*;

public class Painter extends DiagramElement {

    private Shape shape;
    public Painter(String name, ClassyNode parent) {
        super(name, parent);
    }

}
