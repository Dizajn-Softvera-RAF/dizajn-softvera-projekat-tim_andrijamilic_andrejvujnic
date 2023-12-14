package raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;

import javax.swing.*;
import javax.swing.border.StrokeBorder;
import javax.swing.plaf.synth.ColorType;
import java.awt.*;

@Getter
@Setter
public abstract class DiagramElement extends ClassyNode {

    private Color boja;
    private int stroke;
    private raf.dsw.classycraft.app.gui.swing.painter.Painter painter;

    public DiagramElement(String name, ClassyNode parent) {

        super(name, parent);
    }

}
