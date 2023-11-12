package raf.dsw.classycraft.app.logger;

public class ConsoleLogger implements Logger {

    @Override
    public void log() {

    }

    @Override
    public void update(Object notification) {
        System.out.println(notification);
    }
}
