package raf.dsw.classycraft.app;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.ClassyRepository;
import raf.dsw.classycraft.app.core.ClassyRepositoryImpl;
import raf.dsw.classycraft.app.core.Gui;
import raf.dsw.classycraft.app.gui.swing.SwingGui;
import raf.dsw.classycraft.app.model.messanger.MessageGenerator;

public class AppCore {
    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        Gui gui=new SwingGui();
        ClassyRepository classyRepository = new ClassyRepositoryImpl();
        MessageGenerator messageGenerator = new MessageGenerator();
        appCore.initialize(gui, classyRepository, messageGenerator);
        appCore.run();
    }
}