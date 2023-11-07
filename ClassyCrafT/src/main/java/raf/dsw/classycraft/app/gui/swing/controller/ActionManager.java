package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ActionManager {
    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private EditAction editAction;
    private AboutUs aboutUs;

    public ActionManager()
    {
        initialiseAction();
    }

    public void initialiseAction()
    {
        exitAction=new ExitAction();
        newProjectAction=new NewProjectAction();
        editAction=new EditAction();
        aboutUs=new AboutUs();
    }
}
