package raf.dsw.classycraft.app.model.repositoryModel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public abstract class ClassyNodeComposite extends ClassyNode {
    private List<ClassyNode> children;

    public ClassyNodeComposite(String name, ClassyNode parent) {
        super();
    }

    public abstract void addChild(ClassyNode child);

    public abstract void removeChild();
}
