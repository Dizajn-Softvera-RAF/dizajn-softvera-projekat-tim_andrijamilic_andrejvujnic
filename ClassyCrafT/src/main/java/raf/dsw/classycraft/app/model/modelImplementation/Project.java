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

    protected boolean changed = true;
    protected String filePath;

    public Project(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(ClassyNode child) {
        if (child != null &&  child instanceof Package){
            Package pkg = (Package) child;
            if (!this.getChildren().contains(pkg)){
                this.getChildren().add(pkg);
            }
        }
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        changed = true;
    }
}
