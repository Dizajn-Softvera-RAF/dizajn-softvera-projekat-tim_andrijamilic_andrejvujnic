package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.classyRepository.command.implementation.DeleteCommand;
import raf.dsw.classycraft.app.classyRepository.command.implementation.DuplicateCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
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
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DuplicateState implements State {
    int copyCounter = 1;
    @Override
    public void misKliknut(int x, int y, DiagramView dw, MouseEvent event) {

        System.out.println("duplicate");
        List<Painter> selected = dw.getSelectedPainters();
        List<Painter> duplicatedPainters = new ArrayList<>();

        for (Painter p : selected) {
            DiagramElement diagElem = p.getDiagramElement();
            if (diagElem instanceof InterClass) {
                InterClass inter = (InterClass) diagElem;
                Point pos = inter.getPosition();
                if(inter instanceof Klasa){
                    Klasa duplicatedInter = new Klasa("Klasa", dw.getDiagram(), new Point(pos.x + 30, pos.y + 30));
                    duplicatedInter.setKontent(((Klasa) inter).getKontent());
                    DuplicateCommand duplicateCommand = new DuplicateCommand(dw, duplicatedInter);
                    dw.getCommandManager().addCommand(duplicateCommand);
                }else if(inter instanceof Interface){
                    Interface duplicatedInter = new Interface("Interface", dw.getDiagram(), new Point(pos.x + 30, pos.y + 30));
                    duplicatedInter.setKontent(((Interface) inter).getKontent());
                    DuplicateCommand duplicateCommand = new DuplicateCommand(dw, duplicatedInter);
                    dw.getCommandManager().addCommand(duplicateCommand);
                }else if(inter instanceof Enum){
                    Enum duplicatedInter = new Enum("Enum", dw.getDiagram(), new Point(pos.x + 30, pos.y + 30));
                    duplicatedInter.setKontent(((Enum) inter).getKontent());
                    DuplicateCommand duplicateCommand = new DuplicateCommand(dw, duplicatedInter);
                    dw.getCommandManager().addCommand(duplicateCommand);
                }
            }
        }


    }

    @Override
    public void misPritisnut(int x, int y, DiagramView dw) {

    }

    @Override
    public void misOtpusten(int x, int y, DiagramView dw) {

    }

    @Override
    public void misPovucen(int x, int y, DiagramView dw) {

    }
}
