package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImpl;
import raf.dsw.classycraft.app.observer.ISubscriber;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PackageView extends JPanel implements ISubscriber {

    private Package model;
    private PackageToolBar ptb = new PackageToolBar();
    private JTabbedPane tp = new JTabbedPane();

    public PackageView(Package model)
    {
        this.model = model;
        model.addSubscriber(this);
        initialise();
    }
    private void initialise()
    {
        initialiseGui();
    }

    private void initialiseGui(){

        //JPanel panel = new JPanel(new BorderLayout());

        JLabel l1 = new JLabel(model.getName());
        JLabel l2 = new JLabel("user");

        this.add(l1);
        this.add(l2);

        for(ClassyNode child : model.getChildren()){
            if(child instanceof Diagram){
                tp.addTab(child.getName(), new DiagramView());
            }
        }

        this.add(tp);
        this.add(ptb);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //this.add(panel);

    }

    @Override
    public void update(Object notification) {
        tp.removeAll();
        for(ClassyNode child : model.getChildren()){
            if(child instanceof Diagram){
                tp.addTab(child.getName(), new DiagramView());
            }
        }


    }
}
