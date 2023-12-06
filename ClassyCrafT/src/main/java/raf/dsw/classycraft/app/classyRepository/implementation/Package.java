package raf.dsw.classycraft.app.classyRepository.implementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.observer.IPublisher;
import raf.dsw.classycraft.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Package extends ClassyNodeComposite implements IPublisher {
    private List<ISubscriber> subs = new ArrayList<>();
    public Package(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(ClassyNode child) {
        if (child != null &&  child instanceof Diagram){
            Diagram dim = (Diagram) child;
            if (!this.getChildren().contains(dim)){
                this.getChildren().add(dim);
                notifySubscriber(child);
            }
        }
    }

    @Override
    public void removeChild(ClassyNode child) {
       this.getChildren().remove(child);
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
}
