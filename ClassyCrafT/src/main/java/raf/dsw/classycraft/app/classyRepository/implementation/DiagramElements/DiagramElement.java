package raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;

import javax.swing.*;
import javax.swing.border.StrokeBorder;
import javax.swing.plaf.synth.ColorType;

public abstract class DiagramElement extends ClassyNode {

    private ColorType boja;
    private int stroke;
    private Painter painter;
    public DiagramElement(String name, ClassyNode parent) {
        super(name, parent);
    }

    public Painter getPainter() {
        return painter;
    }
}
