package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImpl;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.state.StateManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

@Getter
@Setter
public class PackageView extends JPanel implements ISubscriber {

    private Package model;
    private DiagramView diagramView;
    private Rectangle2D selekcijaRect = new Rectangle2D.Double();
    private StateManager stateManager = new StateManager();
    private PackageToolBar ptb = new PackageToolBar();
    private JTabbedPane tp = new JTabbedPane();

    public PackageView(Package model)
    {
        this.model = model;
        model.addSubscriber(this);
        initialise();
    }

    public DiagramView getDW(){
        System.out.println(tp.getSelectedComponent());
        return (DiagramView) tp.getSelectedComponent();
    }

    public PackageView() {

    }

    private void initialise()
    {
        initialiseGui();
    }

    private void initialiseGui(){
        ClassyNode parent = model.getParent();

        while(!(parent instanceof Project)){
            parent = parent.getParent();
        }

        JLabel l1 = new JLabel(parent.getName());
        JLabel l2 = new JLabel("user");

        this.add(l1);
        this.add(l2);

        for(ClassyNode child : model.getChildren()){
            if(child instanceof Diagram){
                DiagramView dw = new DiagramView((Diagram)child );
                ((Diagram) child).addSubscriber(dw);
                tp.addTab(child.getName(), dw);
            }
        }

        this.add(tp);
        this.add(ptb);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

    public void misKliknut(int x, int y, DiagramView dw, MouseEvent event){
        this.stateManager.getCurrentState().misKliknut(x, y, dw, event);

    };
    public void misPritisnut(int x, int y, DiagramView dw){
        this.stateManager.getCurrentState().misPritisnut(x, y, dw);
    };

    public void misOtpusten(int x, int y, DiagramView dw){
        this.stateManager.getCurrentState().misOtpusten(x, y, dw);
    };

    public void misPovucen(int x, int y, DiagramView dw){
        this.stateManager.getCurrentState().misPovucen(x, y, dw);
    };

    public void startAddClassState(){
        this.stateManager.setAddClassState();

    }
    public void startAddInterfaceState()
    {
        this.stateManager.setAddInterfaceState();
    }
    public void startAddEnumState()
    {
        this.stateManager.setAddEnumState();
    }
    public void startDeleteState()
    {
        this.stateManager.setDeleteState();
    }
    public void startAgregacijaState(){
        this.stateManager.setAddAgregacijaState();
    }
    public void startGeneralizacijaState(){
        this.stateManager.setAddGeneralizacijeState();
    }
    public void startZavisnostState(){
        this.stateManager.setAddZavisnostState();
    }
    public void startKompozicijaState(){
        this.stateManager.setAddKompozicijaState();
    }
    public void startEditState(){
        this.stateManager.setEditState();
    }
    public void startMoveState(){
        this.stateManager.setMoveState();
    }
    public void startSelectState(){
        this.stateManager.setSelectState();
    }
    public void startZoomState(){
        this.stateManager.setZoomState();
    }
    public void startDuplicateState(){
        this.stateManager.setDuplicateState();
    }

    @Override
    public void update(Object notification) {
        tp.removeAll();
        for(ClassyNode child : model.getChildren()){
            if(child instanceof Diagram){
                tp.addTab(child.getName(), new DiagramView((Diagram) child));
            }
        }

    }
}