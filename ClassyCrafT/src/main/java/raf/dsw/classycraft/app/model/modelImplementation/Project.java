package raf.dsw.classycraft.app.model.modelImplementation;


import raf.dsw.classycraft.app.model.repositoryModel.ClassyNode;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNodeComposite;

public class Project extends ClassyNodeComposite {
    public Project(String name, ClassyNode parent) {
        super(name, parent);
    }
    @Override
    public void addChild(ClassyNode child) {

    }

    @Override
    public void removeChild() {

    }
}
