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
public class Klasa extends InterClass {

    private List<ClassContent> kontent = new ArrayList<>();
    private Point position;
    private Dimension size;

    //menjao
    private String name;
    public Klasa(String name, ClassyNode parent, Point position) {
        super(name, parent);
        this.position = position;
    }

}
