package raf.dsw.classycraft.app.core;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ClassyRepository;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNode;
import raf.dsw.classycraft.app.model.modelImplementation.ProjectExplorer;
@Getter
@Setter
public class ClassyRepositoryImpl implements ClassyRepository {
    private ProjectExplorer root;
    @Override
    public ClassyNode getRoot() {
        return root;
    }
}
