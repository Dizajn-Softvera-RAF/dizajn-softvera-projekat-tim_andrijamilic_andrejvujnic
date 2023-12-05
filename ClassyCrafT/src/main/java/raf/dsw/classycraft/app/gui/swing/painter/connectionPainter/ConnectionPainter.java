package raf.dsw.classycraft.app.gui.swing.painter.connectionPainter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;

public abstract class ConnectionPainter extends Painter {
    public ConnectionPainter(String name, ClassyNode parent) {
        super(name, parent);
    }
}
