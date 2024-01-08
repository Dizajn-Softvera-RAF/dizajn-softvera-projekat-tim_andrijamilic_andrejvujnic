package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.classyRepository.command.implementation.AddEnumCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Enum;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.EnumPainter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.KlasaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;

public class AddEnumState implements State {
    @Override
    public void misKliknut(int x, int y, DiagramView dw, MouseEvent event) {
        AddEnumCommand addEnumCommand = new AddEnumCommand(dw, new Point(x, y), new Enum("Enum" + dw.getCount(), dw.getDiagram(), new Point(x, y)));
        dw.getCommandManager().addCommand(addEnumCommand);
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
