package raf.dsw.classycraft.app.core;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ClassyRepository;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNode;
import raf.dsw.classycraft.app.model.modelImplementation.ProjectExplorer;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNodeComposite;

@Getter
@Setter
public class ClassyRepositoryImpl implements ClassyRepository {
    private ProjectExplorer root;

    public ClassyRepositoryImpl(){
        root = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return root;
    }

    @Override
    public ClassyNode getRoot() {
        return root;
    }

    @Override
    public void addChild(ClassyNodeComposite parent, ClassyNode child) {

    }
}
