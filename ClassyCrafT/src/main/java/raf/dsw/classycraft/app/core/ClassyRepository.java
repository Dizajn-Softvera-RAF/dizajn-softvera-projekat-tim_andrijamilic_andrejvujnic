package raf.dsw.classycraft.app.core;

import raf.dsw.classycraft.app.model.modelImplementation.ProjectExplorer;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNode;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNodeComposite;

public interface ClassyRepository {
    ProjectExplorer getProjectExplorer();
    public ClassyNode getRoot();
    void addChild(ClassyNodeComposite parent, ClassyNode child);
}
