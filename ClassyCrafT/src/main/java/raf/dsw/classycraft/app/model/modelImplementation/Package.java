package raf.dsw.classycraft.app.model.modelImplementation;

import raf.dsw.classycraft.app.model.repositoryModel.ClassyNode;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNodeComposite;

public class Package extends ClassyNodeComposite {
    public Package(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(ClassyNode child) {
        if (child != null &&  child instanceof Diagram){
            Diagram dim = (Diagram) child;
            if (!this.getChildren().contains(dim)){
                this.getChildren().add(dim);
            }
        }
    }

    @Override
    public void removeChild(ClassyNode child) {

    }
}
