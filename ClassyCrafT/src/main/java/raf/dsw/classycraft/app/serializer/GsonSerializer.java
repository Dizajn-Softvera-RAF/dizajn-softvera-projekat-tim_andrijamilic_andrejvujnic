package raf.dsw.classycraft.app.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.core.Serializer;
import raf.dsw.classycraft.app.serializer.adapters.ColorAdapter;
import raf.dsw.classycraft.app.serializer.adapters.DimensionAdapter;
import raf.dsw.classycraft.app.serializer.adapters.PointAdapter;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonSerializer implements Serializer {

    private final Gson gson;
    private GsonBuilder gsonBuilder = new GsonBuilder();

    public GsonSerializer() {
        DiagramElementSerializer elementModelSerializer = new DiagramElementSerializer();
        gsonBuilder.registerTypeAdapter(Color.class, new ColorAdapter());
        gsonBuilder.registerTypeAdapter(Diagram.class, new DiagramSerializer());
        gsonBuilder.registerTypeAdapter(Project.class, new ProjectSerializer());
        gsonBuilder.registerTypeAdapter(DiagramElement.class, elementModelSerializer);
        gsonBuilder.registerTypeAdapter(InterClass.class, elementModelSerializer);
        gsonBuilder.registerTypeAdapter(Package.class, new PackageSerializer());
        gsonBuilder.registerTypeAdapter(Point.class, new PointAdapter());
        gsonBuilder.registerTypeAdapter(Dimension.class, new DimensionAdapter());
        gson = gsonBuilder.create();
    }
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

    @Override
    public void saveTemplate(Diagram diagram, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            gson.toJson(diagram, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Diagram loadTemplate(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, Diagram.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
