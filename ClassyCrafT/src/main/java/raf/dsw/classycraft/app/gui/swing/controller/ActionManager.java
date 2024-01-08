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
    private UndoAction undoAction;
    private RedoAction redoAction;
    private SaveAction saveAction;
    private SaveAsAction saveAsAction;
    private LoadAction loadAction;
    private SavePictureAction savePictureAction;
    private SaveAsTemplateAction saveAsTemplateAction;
    private LoadTemplateAction loadTemplateAction;
    private ExportAction exportAction;

    private AddInterClassAction addInterClassAction;
    private AddClassAction addClassAction;
    private DuplicateAction duplicateAction;
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
        duplicateAction = new DuplicateAction();

        addInterClassAction = new AddInterClassAction();
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        editAction = new EditAction();
        aboutUs = new AboutUs();
        deleteAction = new DeleteAction();
        undoAction = new UndoAction();
        redoAction = new RedoAction();
        saveAction = new SaveAction();
        saveAsAction = new SaveAsAction();
        loadAction = new LoadAction();
        savePictureAction = new SavePictureAction();
        saveAsTemplateAction = new SaveAsTemplateAction();
        loadTemplateAction = new LoadTemplateAction();
        exportAction = new ExportAction();
    }
}
