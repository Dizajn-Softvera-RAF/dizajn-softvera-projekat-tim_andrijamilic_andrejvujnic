//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package raf.dsw.classycraft.app.classyRepository.command.implementation;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.classContet.Atribut;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.classContet.ClassContent;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.classContet.Metoda;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.gui.swing.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.EditView;

public class EditCommand extends AbstractCommand {
    private int x;
    private int y;
    private DiagramView dw;
    private MouseEvent event;
    private EditView ed;

    public EditCommand(int x, int y, DiagramView dw, MouseEvent event, EditView ed) {
        this.x = x;
        this.y = y;
        this.dw = dw;
        this.event = event;
        this.ed = ed;
    }

    public void doCommand() {
        ArrayList<Painter> selected = (ArrayList)this.dw.getSelectedPainters();

        for(Iterator var2 = selected.iterator(); var2.hasNext(); this.dw.repaint()) {
            Painter p = (Painter)var2.next();
            DiagramElement de = p.getDiagramElement();
            if (de instanceof Klasa) {
                ArrayList<ClassContent> cc = (ArrayList)((Klasa)de).getKontent();
                String kV = (String)this.ed.getJComboBox().getSelectedItem();
                String kP = this.ed.getTextField().getText();
                String izb = (String)this.ed.getIzbor().getSelectedItem();
                if (izb == "metoda") {
                    Metoda metoda = new Metoda(kV, kP);
                    cc.add(metoda);
                    ((Klasa)de).setKontent(cc);
                } else if (izb == "atribut") {
                    Atribut atribut = new Atribut(kV, kP);
                    cc.add(atribut);
                    ((Klasa)de).setKontent(cc);
                }
            }
        }

    }

    public void undoCommand() {
        ArrayList<Painter> selected = (ArrayList)this.dw.getPainters();

        for(Iterator var2 = selected.iterator(); var2.hasNext(); this.dw.repaint()) {
            Painter p = (Painter)var2.next();
            DiagramElement de = p.getDiagramElement();
            if (de instanceof Klasa) {
                ArrayList<ClassContent> cc = (ArrayList)((Klasa)de).getKontent();
                ClassContent k = (ClassContent)cc.get(cc.size() - 1);
                cc.remove(k);
            }
        }

    }
}
