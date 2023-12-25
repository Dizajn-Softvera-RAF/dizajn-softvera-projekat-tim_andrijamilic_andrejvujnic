package raf.dsw.classycraft.app.classyRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.classyRepository.command.CommandManager;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Connection;
import raf.dsw.classycraft.app.observer.IPublisher;
import raf.dsw.classycraft.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class Diagram extends ClassyNodeComposite implements IPublisher {

    private List<ISubscriber> subs = new ArrayList<>();
    private ArrayList<DiagramElement> models = new ArrayList<>();
    private transient CommandManager commandManager = new CommandManager();
    public Diagram(String name, ClassyNode parent) {
        super(name, parent);
    }



    @Override
    public void addChild(ClassyNode child) {
        getChildren().add(child);
        notifySubscriber(child);
    }

    @Override
    public void addSubscriber(ISubscriber iSubscriber) {
        subs.add(iSubscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber iSubscriber) {

    }

    @Override
    public void notifySubscriber(Object notification) {
        for(ISubscriber subscriber : subs){
            subscriber.update(notification);
        }
    }

    public void addModel(DiagramElement model) {
        if (model == null) return;
        models.add(model);
        if (model instanceof InterClass) notifySubscriber(model);
        else if (model instanceof Connection)  notifySubscriber(model);
    }

}
