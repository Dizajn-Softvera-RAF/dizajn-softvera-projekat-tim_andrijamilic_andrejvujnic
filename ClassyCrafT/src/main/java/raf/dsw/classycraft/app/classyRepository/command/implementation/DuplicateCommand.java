package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Enum;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Interface;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.EnumPainter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.InterClassPainter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.InterfejsPainter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.KlasaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;

public class DuplicateCommand extends AbstractCommand {

    private DiagramView dw;
    private InterClass ic;

    public DuplicateCommand(DiagramView dw, InterClass ic){
        this.dw = dw;
        this.ic = ic;

    }
    @Override
    public void doCommand() {
        if(ic instanceof Klasa){
            KlasaPainter k = new KlasaPainter(ic);
            ic.setPainter(k);
            dw.getDiagram().addChild(ic);
            dw.getPainters().add(k);
            dw.repaint();
        }else if(ic instanceof Interface){
            InterfejsPainter i = new InterfejsPainter(ic);
            ic.setPainter(i);
            dw.getDiagram().addChild(ic);
            dw.getPainters().add(i);
            dw.repaint();
        }else if(ic instanceof Enum){
            EnumPainter e = new EnumPainter(ic);
            ic.setPainter(e);
            dw.getDiagram().addChild(ic);
            dw.getPainters().add(e);
            dw.repaint();
        }

    }

    @Override
    public void undoCommand() {
        Painter k = ic.getPainter();
        dw.getPainters().remove(k);
        dw.getDiagram().removeChild(ic);
        dw.repaint();
    }
}
