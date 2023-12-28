package raf.dsw.classycraft.app.gui.swing.tree;

import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeModel;
import raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;

import javax.swing.*;

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
    public void addChild(ClassyTreeItem parent, int a) {
        if (!(parent.getClassyNode() instanceof ClassyNodeComposite))
            return;

        ClassyNode child = createChild(parent.getClassyNode(), a);
        parent.add(new ClassyTreeItem(child));

        ((ClassyNodeComposite) parent.getClassyNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void removeChild(ClassyTreeItem node) {
        if (!(node.getClassyNode() instanceof ClassyNodeComposite))
            return;

        ClassyTreeItem parent = (ClassyTreeItem) node.getParent();
        if(parent != null){
            parent.remove(node);
            ClassyNode m = parent.getClassyNode();
            ((ClassyNodeComposite) parent.getClassyNode()).removeChild(node.getClassyNode());
            SwingUtilities.updateComponentTreeUI(treeView);
        }

    }


    @Override
    public ClassyTreeItem getSelectedNode() {
        return (ClassyTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public ClassyTreeItem getOpenedNode() {
        return getSelectedNode();
    }

    @Override
    public ClassyTreeView getTreeView() {
        return treeView;
    }

    @Override
    public void loadProject(Project node) {
       /* ClassyTreeItem loadedProject = new ClassyTreeItem(node);
        treeModel.getRoot().add(loadedProject);

        ClassyNodeComposite classyNode = (ClassyNodeComposite) treeModel.getRoot().getClassyNode();
        classyNode.addChild(node);

        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);*/
        node.setParent(((ClassyTreeItem) treeModel.getRoot()).getClassyNode());
        ClassyTreeItem loadedProject = new ClassyTreeItem(node);
        ((ClassyTreeItem) treeModel.getRoot()).add(loadedProject);

        ClassyNodeComposite classyNode = (ClassyNodeComposite) ((ClassyTreeItem) treeModel.getRoot()).getClassyNode();
        classyNode.addChild(node);

        for (ClassyNode map : node.getChildren()) {
            map.setParent(node);
            ClassyTreeItem mapTreeItem = new ClassyTreeItem(map);
            loadedProject.add(mapTreeItem);
        }
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    private ClassyNode createChild(ClassyNode parent, int a) {
        if (parent instanceof ProjectExplorer){
            return  new Project("Project" +(cout++), parent);
        }else if (parent instanceof Project){
            return  new Package("Package" + (cout1++), parent);
        }else if (parent instanceof Package && a == 1){
            return  new Package("Package" + (cout1++), parent);
        }else if(parent instanceof Package && a == 0){
            return  new Diagram("Diagram" +(cout2++), parent);
        }else if(parent instanceof Diagram){
            return  new Klasa("Klasa" + (cout2++), parent, null);
        }
        return null;
    }
}
