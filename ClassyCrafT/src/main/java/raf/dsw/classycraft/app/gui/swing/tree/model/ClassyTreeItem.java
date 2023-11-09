package raf.dsw.classycraft.app.gui.swing.tree.model;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNode;

import javax.swing.tree.DefaultMutableTreeNode;
@Setter
@Getter
public class ClassyTreeItem extends DefaultMutableTreeNode {

    private ClassyNode classyNode;

    public ClassyTreeItem(ClassyNode nodeModel) {
        this.classyNode = nodeModel;
    }

    @Override
    public String toString() {
        return classyNode.getName();
    }

    public void setName(String name) {
        this.classyNode.setName(name);
    }
}
