package raf.dsw.classycraft.app.classyRepository.implementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.observer.IPublisher;
import raf.dsw.classycraft.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Diagram extends ClassyNodeComposite implements IPublisher {

    private List<ISubscriber> subs = new ArrayList<>();

    public Diagram(String name, ClassyNode parent) {
        super(name, parent);
        //System.out.println("Diagram");
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
        //updade
        System.out.println(subs.size() + " subs");
        for(ISubscriber subscriber : subs){
            subscriber.update(notification);
        }
    }
}
