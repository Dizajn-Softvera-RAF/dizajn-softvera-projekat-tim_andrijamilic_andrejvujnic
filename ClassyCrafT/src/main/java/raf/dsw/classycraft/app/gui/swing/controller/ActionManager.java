package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.controller.action.*;
import raf.dsw.classycraft.app.gui.swing.controller.stateAction.*;

@Getter
@Setter

public class ActionManager {
    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private EditAction editAction;
    private AboutUs aboutUs;
    private DeleteAction deleteAction;
    private AddInterClassAction addInterClassAction;
// sve nove akcije
    private AddClassAction addClassAction;
    private AddInterfaceAction addInterfaceAction;
    private AddEnumAction addEnumAction;
    private DeleteStateAction deleteStateAction;
    private AddConnectionAction addConnectionAction;
    private EditActionS editActionS;
    private MoveAction moveAction;
    private SelectAction selectAction;
    private ZoomAction zoomAction;

    public ActionManager()
    {
        initialiseAction();
    }

    public void initialiseAction()
    {
        addClassAction = new AddClassAction();
        addInterfaceAction = new AddInterfaceAction();
        addEnumAction = new AddEnumAction();
        deleteStateAction = new DeleteStateAction();
        addConnectionAction = new AddConnectionAction();
        editActionS = new EditActionS();
        moveAction = new MoveAction();
        selectAction = new SelectAction();
        zoomAction = new ZoomAction();

        addInterClassAction = new AddInterClassAction();
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        editAction = new EditAction();
        aboutUs = new AboutUs();
        deleteAction = new DeleteAction();
    }
}
