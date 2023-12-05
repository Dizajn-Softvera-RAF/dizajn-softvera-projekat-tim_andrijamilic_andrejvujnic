package raf.dsw.classycraft.app.classyRepository.implementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.observer.IPublisher;
import raf.dsw.classycraft.app.observer.ISubscriber;

public class Diagram extends ClassyNodeComposite implements IPublisher {

    public Diagram(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(ClassyNode child) {

    }

    @Override
    public void addSubscriber(ISubscriber iSubscriber) {

    }

    @Override
    public void removeSubscriber(ISubscriber iSubscriber) {

    }

    @Override
    public void notifySubscriber(Object notification) {

    }
}
