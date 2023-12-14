package raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.classContet.ClassContent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Interface extends InterClass {

    private Point position;
    private Dimension size;
    private Color boja;

    //menjao
    private String name;
    private List<ClassContent> kontent = new ArrayList<>();
    public Interface(String name, ClassyNode parent, Point position) {
        super(name, parent);
        this.position = position;

    }
}
