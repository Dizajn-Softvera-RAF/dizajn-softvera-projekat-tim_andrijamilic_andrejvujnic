package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTree;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public abstract class AbstractClassyAction extends AbstractAction {

    public Icon loadIcon(String fileName){

        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        else {
            System.err.println("Resource not found: " + fileName);
        }
        return icon;
    }

    public Project getProjectToSave() {
        ClassyTreeItem openedNode = ((ClassyTree) MainFrame.getInstance().getClassyTree()).getOpenedNode();
        ClassyTreeItem selectedNode = MainFrame.getInstance().getClassyTree().getSelectedNode();

        Project project = null;
        // postavljamo za projekat prvo otvoreni projekat, ukoliko projekat nije otvoren, onda postavljamo selektovani projekat
        // ukoliko ni projekat nije selektovan onda obavestavamo korisnika da uradi jedno ili drugo
        if (openedNode != null) {
            project = (Project) openedNode.getClassyNode();
        } else if (selectedNode != null && selectedNode.getClassyNode() instanceof Project) {
            project = (Project) selectedNode.getClassyNode();
        }

        return project;
    }

    public Diagram getDiagramToSave() {
        DiagramView currentDiagramView = ((PackageView)(MainFrame.getInstance().getSplit().getRightComponent())).getDW();
        ClassyTreeItem selectedNode = MainFrame.getInstance().getClassyTree().getSelectedNode();

        Diagram diagram = null;

        if (currentDiagramView != null) {
            diagram = currentDiagramView.getDiagram();
        } else if (selectedNode != null && selectedNode.getClassyNode() instanceof Diagram) {
            diagram = (Diagram) selectedNode.getClassyNode();
        }

        return diagram;
    }

}
