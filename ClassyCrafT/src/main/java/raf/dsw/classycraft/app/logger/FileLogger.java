package raf.dsw.classycraft.app.logger;

import java.io.File;
import java.io.FileWriter;

public class FileLogger implements Logger {
    File f=new File("log.txt");

    @Override
    public void log() {

    }

    @Override
    public void update(Object notification) {
        try {
            FileWriter writer = new FileWriter(f, true);
            writer.append(notification + "\n");
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
