package raf.dsw.classycraft.app.serializer;

//import com.google.gson.Gson;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.core.Serializer;

import java.io.File;

public class GsonSerializer implements Serializer {

    //private final Gson gson = new Gson();
    @Override
    public Project loadProject(File file) {
        return null;
    }

    @Override
    public void saveProject(Project node) {

    }
}
