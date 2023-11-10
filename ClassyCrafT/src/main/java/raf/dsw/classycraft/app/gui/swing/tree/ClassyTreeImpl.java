package raf.dsw.classycraft.app.gui.swing.tree;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeModel;
import raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;
import raf.dsw.classycraft.app.model.modelImplementation.Diagram;
import raf.dsw.classycraft.app.model.modelImplementation.Package;
import raf.dsw.classycraft.app.model.modelImplementation.Project;
import raf.dsw.classycraft.app.model.modelImplementation.ProjectExplorer;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNode;
import raf.dsw.classycraft.app.model.repositoryModel.ClassyNodeComposite;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.Random;

public class ClassyTreeImpl implements ClassyTree{
    private ClassyTreeView treeView;
    private ClassyTreeModel treeModel;
    private static int cout = 1;
    private static int cout1 = 1;
    private static int cout2 = 1;

    @Override
    public ClassyTreeView generateTree(ProjectExplorer projectExplorer) {
        ClassyTreeItem root = new ClassyTreeItem(projectExplorer);
        treeModel = new ClassyTreeModel(root);
        treeView = new ClassyTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(ClassyTreeItem parent) {
        if (!(parent.getClassyNode() instanceof ClassyNodeComposite))
            return;

        ClassyNode child = createChild(parent.getClassyNode());
        parent.add(new ClassyTreeItem(child));
        ((ClassyNodeComposite) parent.getClassyNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
       /* ClassyTreeItem child = new ClassyTreeItem(createChild(parent.getClassyNode()));
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);*/
    }


    @Override
    public ClassyTreeItem getSelectedNode() {
        return (ClassyTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public ClassyTreeView getTreeView() {
        return treeView;
    }

    @Override
    public void loadProject(Project node) {
        ClassyTreeItem loadedProject = new ClassyTreeItem(node);
        treeModel.getRoot().add(loadedProject);

        ClassyNodeComposite classyNode = (ClassyNodeComposite) treeModel.getRoot().getClassyNode();
        classyNode.addChild(node);

        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    private ClassyNode createChild(ClassyNode parent) {
        if (parent instanceof ProjectExplorer){
            return  new Project("Project" +(cout++), parent);
        }else if (parent instanceof Project){
            return  new Package("Package" + (cout1++), parent);
        }else if (parent instanceof Package){
            return  new Diagram("Diagram" +(cout2++), parent);
        }
        return null;
    }
}
