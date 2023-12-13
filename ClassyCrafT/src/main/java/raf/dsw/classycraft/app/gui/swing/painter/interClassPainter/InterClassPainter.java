package raf.dsw.classycraft.app.gui.swing.painter.interClassPainter;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;

import java.awt.*;
@Getter
@Setter
public abstract class InterClassPainter extends Painter {

    public InterClassPainter(DiagramElement element) {
        super(element);
    }
}
