package raf.dsw.classycraft.app.model.logger;

import raf.dsw.classycraft.app.model.messanger.Message;
import raf.dsw.classycraft.app.observer.ISubscriber;

public interface Logger extends ISubscriber {
    public void log();
}
