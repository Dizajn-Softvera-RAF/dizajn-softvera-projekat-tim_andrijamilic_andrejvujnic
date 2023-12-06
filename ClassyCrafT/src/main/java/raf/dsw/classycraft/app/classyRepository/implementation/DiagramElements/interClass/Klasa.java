package raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.classContet.ClassContent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Klasa extends InterClass {

    private List<ClassContent> kontent = new ArrayList<>();
    private Point position;
    private Dimension size;
    public Klasa(String name, ClassyNode parent) {
        super(name, parent);
    }

}
