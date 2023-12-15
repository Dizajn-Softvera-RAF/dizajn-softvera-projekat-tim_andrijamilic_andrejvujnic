package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Generalizacija;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Kompozicija;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.GeneralizacijaPainter;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.KompozicijaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.state.State;

import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class AddKompozicijaState implements State {
    private Painter from;
    private Painter to;
    @Override
    public void misKliknut(int x, int y, DiagramView dw, MouseEvent event) {

    }

    @Override
    public void misPritisnut(int x, int y, DiagramView dw) {
        Rectangle2D selectForConnection = new Rectangle2D.Double(x, y, 1, 1);;
        System.out.println("veza");
        if(from != null)
        {
            // one painter already found - find next
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
                        Kompozicija con = new Kompozicija("connection1", dw.getDiagram(), (InterClass) from.getDiagramElement(), (InterClass) to.getDiagramElement());
                        dw.getDiagram().addChild(con);
                        dw.getPainters().add(new KompozicijaPainter(con));
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


            // find first painter
            if (selectForConnection.intersects(painter.getShape().getBounds())) {
                from = painter;
                break;
            }
        }
    }

    @Override
    public void misOtpusten(int x, int y, DiagramView dw) {

    }

    @Override
    public void misPovucen(int x, int y, DiagramView dw) {

    }
}
