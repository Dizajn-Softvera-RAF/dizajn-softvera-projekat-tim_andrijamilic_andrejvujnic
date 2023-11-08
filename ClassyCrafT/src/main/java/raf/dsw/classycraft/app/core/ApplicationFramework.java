package raf.dsw.classycraft.app.core;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.model.messanger.MessageGenerator;
import raf.dsw.classycraft.app.model.messanger.MessageType;
import raf.dsw.classycraft.app.model.modelImplementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

@Getter
@Setter
public class ApplicationFramework {

    protected Gui gui;
    private ActionManager actionManager;
    private ClassyRepositoryImpl classyRepository;
    private ProjectExplorer projectExplorer;
    private MessageGenerator messageGenerator;
    private static ApplicationFramework instance;

    //buduca polja za model celog projekta

    public void run()
    {
        this.gui.start();
    }
    public void initialize(Gui gui){
        this.gui=gui;
        messageGenerator = new MessageGenerator();
        //messageGenerator.addSubscriber("CONSOLE_LOGGER");
        //messageGenerator.addSubscriber("FILE_LOGGER");
        //messageGenerator.addSubscriber("MAINFRAME");
        MainFrame.getInstance().setVisible(true);
    }

    private ApplicationFramework(){
        actionManager = new ActionManager();
        classyRepository = new ClassyRepositoryImpl();
        projectExplorer= (ProjectExplorer) classyRepository.getRoot();
    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}
