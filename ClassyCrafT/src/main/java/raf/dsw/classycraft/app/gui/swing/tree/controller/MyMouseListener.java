package raf.dsw.classycraft.app.gui.swing.tree.controller;

import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        ClassyTreeItem selected = (ClassyTreeItem) MainFrame.getInstance().getClassyTree().getSelectedNode();
        if(selected.getClassyNode() instanceof Package) {
            if (e.getClickCount() == 2) {
                MainFrame.getInstance().getSplit().setRightComponent(new PackageView((Package) selected.getClassyNode()));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
