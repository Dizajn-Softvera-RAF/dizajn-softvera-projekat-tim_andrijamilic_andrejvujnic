package raf.dsw.classycraft.app.model.repositoryModel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public abstract class ClassyNodeComposite extends ClassyNode {
    private List<ClassyNode> children;
    public abstract void addChild();

    public abstract void removeChild();
}
