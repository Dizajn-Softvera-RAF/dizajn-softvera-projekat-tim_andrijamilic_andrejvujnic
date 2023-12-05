package raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;

public abstract class DiagramElement extends ClassyNode {
    public DiagramElement(String name, ClassyNode parent) {
        super(name, parent);
    }
}
