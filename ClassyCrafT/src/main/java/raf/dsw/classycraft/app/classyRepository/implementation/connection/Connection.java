package raf.dsw.classycraft.app.classyRepository.implementation.connection;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;

import java.awt.*;
@Getter
@Setter
public abstract class Connection extends DiagramElement {
    private InterClass od;
    private InterClass doo;

    public Connection(String name, ClassyNode parent, InterClass od, InterClass doo) {

        super(name, parent);
        this.od = od;
        this.doo = doo;
    }
}
