//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package raf.dsw.classycraft.app.gui.swing.controller.action;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import raf.dsw.classycraft.app.classyRepository.command.implementation.EditCommand;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.EditView;

public class DodajKontetAction extends AbstractClassyAction {
    private int x;
    private int y;
    private DiagramView dw;
    private MouseEvent event;
    private EditView ed;

    public DodajKontetAction(int x, int y, DiagramView dw, MouseEvent event, EditView ed) {
        this.x = x;
        this.y = y;
        this.dw = dw;
        this.event = event;
        this.ed = ed;
    }

    public void actionPerformed(ActionEvent e) {
        EditCommand editCommand = new EditCommand(this.x, this.y, this.dw, this.event, this.ed);
        this.dw.getCommandManager().addCommand(editCommand);
    }
}
