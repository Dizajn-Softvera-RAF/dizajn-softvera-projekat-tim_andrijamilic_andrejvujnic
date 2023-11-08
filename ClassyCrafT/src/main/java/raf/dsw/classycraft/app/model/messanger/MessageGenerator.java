package raf.dsw.classycraft.app.model.messanger;

import raf.dsw.classycraft.app.observer.IPublisher;
import raf.dsw.classycraft.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class MessageGenerator implements IPublisher {
    private MessageType messageType;
    private List<ISubscriber> subs;

    public MessageGenerator() {
        init();
    }
    private void init(){
        subs = new ArrayList<>();
    }
    public void generateMessage(String text, MessageType messageType){
        this.messageType = messageType;
        //sa tekstom radite sami
    }
    public MessageType getMessageType() {
        return messageType;
    }

    public List<ISubscriber> getSubs() {
        return subs;
    }

    @Override
    public void addSubscriber(ISubscriber iSubscriber) {
        this.subs.add(iSubscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber iSubscriber) {
        this.subs.remove(iSubscriber);
    }

    @Override
    public void notifySubscriber(ISubscriber iSubscriber) {
        for(ISubscriber subscriber : subs){
            subscriber.update(this);
        }
    }
}
