package raf.dsw.classycraft.app.gui.swing.painter.interClassPainter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;

public abstract class InterClassPainter extends Painter {
    public InterClassPainter(String name, ClassyNode parent) {
        super(name, parent);
    }
}
