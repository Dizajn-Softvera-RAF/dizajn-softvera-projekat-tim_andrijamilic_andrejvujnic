package raf.dsw.classycraft.app.model.modelImplementation;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNode;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNodeComposite;
@ToString(callSuper = true)
@Getter
@Setter
public class Project extends ClassyNodeComposite {

    private String autor;
    protected boolean changed = true;
    protected String filePath;

    public Project(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(ClassyNode child) {

    }

    @Override
    public void setName(String name) {
        super.setName(name);
        changed = true;
    }
}
