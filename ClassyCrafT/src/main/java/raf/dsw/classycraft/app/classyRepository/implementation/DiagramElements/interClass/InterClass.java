package raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;

public abstract class InterClass extends DiagramElement {
    private boolean vidljivost;
    private String naziv;

    public InterClass(String name, ClassyNode parent) {
        super(name, parent);
    }
}
