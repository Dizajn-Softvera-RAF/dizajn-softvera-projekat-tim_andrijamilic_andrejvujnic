package raf.dsw.classycraft.app.serializer;

import com.google.gson.Gson;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.core.Serializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonSerializer implements Serializer {

    private final Gson gson = new Gson();
    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, Project.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project node) {
        try (FileWriter writer = new FileWriter(node.getFilePath())) {
            gson.toJson(node, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
