package raf.dsw.classycraft.app.model.modelImplementation;

import raf.dsw.classycraft.app.model.repositoryModel.ClassyNode;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNodeComposite;

public class Package extends ClassyNodeComposite {
    public Package(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(ClassyNode child) {

    }

    @Override
    public void removeChild(ClassyNode child) {

    }
}
