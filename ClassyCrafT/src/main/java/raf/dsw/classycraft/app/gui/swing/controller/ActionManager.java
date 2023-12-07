package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.controller.action.*;
import raf.dsw.classycraft.app.gui.swing.controller.stateAction.AddClassAction;
import raf.dsw.classycraft.app.gui.swing.controller.stateAction.MoveAction;

@Getter
@Setter

public class ActionManager {
    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private EditAction editAction;
    private AboutUs aboutUs;
    private DeleteAction deleteAction;
// sve nove akcije
    private AddClassAction addClassAction;
    private MoveAction moveAction;
    public ActionManager()
    {
        initialiseAction();
    }

    public void initialiseAction()
    {
        moveAction = new MoveAction();
        addClassAction = new AddClassAction();
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        editAction = new EditAction();
        aboutUs = new AboutUs();
        deleteAction = new DeleteAction();
    }
}
