package raf.dsw.classycraft.app.model.repositoryModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class ClassyNode {
    private ClassyNode parent;
    private String name;
}
