package raf.dsw.classycraft.app.state.concrete;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.state.State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.SMALL_ICON;

public class AddClassState implements State{

    public AddClassState(){

    }
    @Override
    public void misKliknut(int x, int y, DiagramView dw) {
        //Klasa k = new Klasa("Klasa");
    }

    @Override
    public void misOtpusten(int x, int y, DiagramView dw) {

    }

    @Override
    public void misPovucen(int x, int y, DiagramView dw) {

    }
}
