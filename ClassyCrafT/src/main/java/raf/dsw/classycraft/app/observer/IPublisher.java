package raf.dsw.classycraft.app.observer;

public interface IPublisher {
    void addSubscriber(ISubscriber iSubscriber);
    void removeSubscriber(ISubscriber iSubscriber);
    void notifySubscriber(ISubscriber iSubscriber);
}
