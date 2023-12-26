package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.classyRepository.command.implementation.AddClassCommand;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.KlasaPainter;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImpl;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.state.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.SMALL_ICON;

public class AddClassState implements State{

    public AddClassState(){
    }
    @Override
    public void misKliknut(int x, int y, DiagramView dw, MouseEvent event) {
       /* System.out.println("add");
        Klasa k = new Klasa("Klasa", dw.getDiagram(), new Point(x, y));

        KlasaPainter kp = new KlasaPainter(k);
        dw.getDiagram().addChild(k);
        dw.getPainters().add(kp);
        k.setPainter(kp);*/

        AddClassCommand addClassCommand = new AddClassCommand(dw, new Point(x, y));
        dw.getCommandManager().addCommand(addClassCommand);

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
