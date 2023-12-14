package raf.dsw.classycraft.app.classyRepository.composite;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public abstract class ClassyNode {
    private transient ClassyNode parent;
    @ToString.Exclude
    private String name;

    public ClassyNode(String name, ClassyNode parent) {
        this.name = name;
        this.parent = parent;
    }

    /*@Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof ClassyNode) {
            ClassyNode otherObj = (ClassyNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }*/
}
