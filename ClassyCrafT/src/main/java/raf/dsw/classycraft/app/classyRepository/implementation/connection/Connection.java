package raf.dsw.classycraft.app.classyRepository.implementation.connection;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;

public abstract class Connection extends DiagramElement {
    private InterClass od;
    private InterClass doo;

    public Connection(String name, ClassyNode parent) {
        super(name, parent);
    }
}
