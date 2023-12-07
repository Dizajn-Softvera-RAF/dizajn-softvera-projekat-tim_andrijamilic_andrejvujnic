package raf.dsw.classycraft.app.gui.swing.painter.connectionPainter;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;

import javax.swing.*;
import java.awt.*;

public abstract class ConnectionPainter extends Painter {
    public ConnectionPainter(DiagramElement element) {
        super(element);
    }
}
