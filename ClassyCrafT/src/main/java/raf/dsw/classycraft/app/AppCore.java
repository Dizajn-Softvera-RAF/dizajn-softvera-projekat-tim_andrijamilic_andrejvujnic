package raf.dsw.classycraft.app;

import raf.dsw.classycraft.app.core.*;
import raf.dsw.classycraft.app.gui.swing.SwingGui;
import raf.dsw.classycraft.app.messanger.MessageGenerator;
import raf.dsw.classycraft.app.serializer.GsonSerializer;

public class AppCore {
    private static AppCore instance;

    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        Gui gui=new SwingGui();
        ClassyRepository classyRepository = new ClassyRepositoryImpl();
        MessageGenerator messageGenerator = new MessageGenerator();
        GsonSerializer serializer = new GsonSerializer();
        appCore.initialize(gui, classyRepository, messageGenerator, serializer);
        appCore.run();
    }
}