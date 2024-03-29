package raf.dsw.classycraft.app.classyRepository.implementation;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
@ToString(callSuper = true)
@Getter
@Setter
public class Project extends ClassyNodeComposite {

    private String author = "author";
    private static int counter = 0;
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

    public Project(String name, ClassyNode parent, String filePath) {
        super(name, parent);
        this.filePath = filePath;
    }

    public Project() {
        super("Project " + counter, null);
        counter++;
    }
}
