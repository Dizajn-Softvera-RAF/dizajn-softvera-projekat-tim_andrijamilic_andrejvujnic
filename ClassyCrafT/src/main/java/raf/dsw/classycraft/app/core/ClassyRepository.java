package raf.dsw.classycraft.app.core;

import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;

public interface ClassyRepository {
    ProjectExplorer getProjectExplorer();
    public ClassyNode getRoot();
    void addChild(ClassyNodeComposite parent, ClassyNode child);
}
