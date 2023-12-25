package raf.dsw.classycraft.app.core;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.logger.ConsoleLogger;
import raf.dsw.classycraft.app.logger.FileLogger;
import raf.dsw.classycraft.app.logger.Logger;
import raf.dsw.classycraft.app.messanger.MessageGenerator;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

@Getter
@Setter
public class ApplicationFramework {

    protected Gui gui;
    private ActionManager actionManager;
    protected ClassyRepositoryImpl classyRepositoryImpl;
    protected ClassyRepository classyRepository;
    private ProjectExplorer projectExplorer;
    private MessageGenerator messageGenerator;
    private Logger consoleLogger;
    private Logger fileLogger;
    private Serializer serializer;
    private static ApplicationFramework instance;


    public void run()
    {
        this.gui.start();
    }
    public void initialize(Gui gui, ClassyRepository classyRepository, MessageGenerator messageGenerator, Serializer serializer){
        this.gui=gui;
        this.classyRepository = classyRepository;
        this.messageGenerator = messageGenerator;
        this.serializer = serializer;
        messageGenerator.addSubscriber(consoleLogger);
        messageGenerator.addSubscriber(fileLogger);
        messageGenerator.addSubscriber(MainFrame.getInstance());
        MainFrame.getInstance().setVisible(true);
    }

    private ApplicationFramework(){
        actionManager = new ActionManager();
        classyRepository = new ClassyRepositoryImpl();
        consoleLogger = new ConsoleLogger();
        fileLogger = new FileLogger();
        projectExplorer= (ProjectExplorer) classyRepository.getRoot();
    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}
