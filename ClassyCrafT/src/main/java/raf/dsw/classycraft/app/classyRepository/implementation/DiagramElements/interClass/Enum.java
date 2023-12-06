package raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.classContet.ClassContent;

import java.util.ArrayList;
import java.util.List;

public class Enum extends InterClass {

    private List<ClassContent> kontent = new ArrayList<>();

    public Enum(String name, ClassyNode parent) {
        super(name, parent);
    }
}
