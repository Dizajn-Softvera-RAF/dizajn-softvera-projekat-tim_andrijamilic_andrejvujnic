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
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Enum;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Interface;
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

    private ClassContent cc;
    private String string;
    private DiagramElement diagramElement;

    private ArrayList<DiagramElement> selecte;

    public EditCommand(int x, int y, DiagramView dw, MouseEvent event, EditView ed) {
        this.x = x;
        this.y = y;
        this.dw = dw;
        this.event = event;
        this.ed = ed;
        this.selecte = getSelectedModels((ArrayList<Painter>) dw.getSelectedPainters());
    }

    public void doCommand() {
        ArrayList<Painter> selected = new ArrayList<>();
        for(DiagramElement de : selecte){
            selected.add(de.getPainter());
        }
        for(Iterator var2 = selected.iterator(); var2.hasNext(); this.dw.repaint()) {
            Painter p = (Painter)var2.next();
            DiagramElement de = p.getDiagramElement();
            diagramElement = de;
            if (de instanceof Klasa) {
                String kV = (String)this.ed.getJComboBox().getSelectedItem();
                String kP = this.ed.getTextField().getText();
                String izb = (String)this.ed.getIzbor().getSelectedItem();
                if (izb == "metoda") {
                    Metoda metoda = new Metoda(kV, kP);
                    cc = metoda;
                    ((Klasa)de).getKontent().add(cc);
                } else if (izb == "atribut") {
                    Atribut atribut = new Atribut(kV, kP);
                    cc = atribut;
                    ((Klasa)de).getKontent().add(cc);
                }
            }else if(de instanceof Interface){
                String kP = this.ed.getTextField().getText();
                String kV = (String)this.ed.getJComboBox().getSelectedItem();
                Metoda metoda = new Metoda(kV, kP);
                ((Interface) de).getKontent().add(metoda);
            }else if(de instanceof Enum){
                String kP = this.ed.getTextField().getText();
                string = kP;
                ((Enum) de).getKontent().add(string);
            }
        }

    }

    public void undoCommand() {
        if(diagramElement instanceof Klasa){
            ((Klasa) diagramElement).getKontent().remove(cc);

        }else if(diagramElement instanceof Interface){

            ((Interface) diagramElement).getKontent().remove(string);
        }else if(diagramElement instanceof Enum){
            ((Enum) diagramElement).getKontent().remove(string);
        }
        dw.repaint();
    }
    public ArrayList<DiagramElement> getSelectedModels(ArrayList<Painter> selectedPainters) {

        ArrayList<DiagramElement> models = new ArrayList<>();

        for (Painter painter : selectedPainters) {
            models.add(painter.getDiagramElement());
        }

        return models;
    }
}
