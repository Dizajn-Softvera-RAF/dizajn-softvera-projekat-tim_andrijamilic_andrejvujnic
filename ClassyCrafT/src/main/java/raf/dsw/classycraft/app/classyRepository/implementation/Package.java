package raf.dsw.classycraft.app.classyRepository.implementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;

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
