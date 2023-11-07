package raf.dsw.classycraft.app.core;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

@Getter
@Setter
public class ApplicationFramework {

    protected Gui gui;
    private static ApplicationFramework instance;

    //buduca polja za model celog projekta

    public void run()
    {
        this.gui.start();
    }
    public void initialize(Gui gui){
        this.gui=gui;
        MainFrame.getInstance().setVisible(true);
    }

    private ApplicationFramework(){

    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}
