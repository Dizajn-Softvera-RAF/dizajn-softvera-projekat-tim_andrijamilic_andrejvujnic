package raf.dsw.classycraft.app.core;

import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;

import java.io.File;

public interface Serializer {
    Project loadProject(File file);
    void saveProject(Project node);
    void saveTemplate(Diagram diagram, String path);
    Diagram loadTemplate(File file);

}
