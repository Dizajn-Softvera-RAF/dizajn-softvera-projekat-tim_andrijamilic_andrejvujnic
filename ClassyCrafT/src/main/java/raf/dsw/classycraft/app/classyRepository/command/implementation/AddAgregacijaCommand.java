package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Agregacija;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.AgregacijaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.awt.geom.Rectangle2D;
public class AddAgregacijaCommand extends AbstractCommand {

    private DiagramView dw;
    private Point point;
    private Painter from;
    private Painter to;

    public AddAgregacijaCommand(DiagramView diagramView, Point point, Painter from, Painter to) {
        this.dw = diagramView;
        this.point = point;
        this.from = from;
        this.to = to;
    }
    @Override
    public void doCommand() {
        Rectangle2D selectForConnection = new Rectangle2D.Double(point.x , point.y, 1, 1);;
        System.out.println("veza");
        if(from != null)
        {
            for (Painter painter : dw.getPainters()) {
                if(!(painter.getDiagramElement() instanceof InterClass)) continue;

                if(!dw.getPainters().contains(from))
                {
                    from = null;
                }
                else
                {
                    if (selectForConnection.intersects(painter.getShape().getBounds())) {
                        to = painter;
                        Agregacija con = new Agregacija("connection1", dw.getDiagram(), (InterClass) from.getDiagramElement(), (InterClass) to.getDiagramElement());
                        dw.getDiagram().addChild(con);
                        dw.getPainters().add(new AgregacijaPainter(con));
                        from = null;
                        to = null;
                        dw.repaint();
                        return;
                    }
                }

            }

        }
        for (Painter painter : dw.getPainters()) {
            if(!(painter.getDiagramElement() instanceof InterClass)) continue;

            if (selectForConnection.intersects(painter.getShape().getBounds())) {
                from = painter;
                break;
            }
        }

    }

    @Override
    public void undoCommand() {

    }
}
