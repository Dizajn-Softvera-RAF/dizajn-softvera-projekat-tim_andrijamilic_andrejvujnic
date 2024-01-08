package raf.dsw.classycraft.app.gui.swing.controller.action;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.messanger.MessageType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class SavePictureAction extends AbstractClassyAction {

    public SavePictureAction() {
        putValue(SMALL_ICON, loadIcon("/images/picture.png"));
        putValue(NAME, "Save as image");
        putValue(SHORT_DESCRIPTION, "Save the current diagram as an image");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DiagramView diagramView =  ((PackageView)(MainFrame.getInstance().getSplit().getRightComponent())).getDW();

        if (diagramView == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage("Diagram koji zelite da sacuvate kao sliku mora biti otvoren", MessageType.ERROR);
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(diagramView.getDiagram().getName() + ".png"));
        fileChooser.setDialogTitle("Save as Image");
        int result = fileChooser.showSaveDialog(diagramView);
        if(result == JFileChooser.APPROVE_OPTION){
            BufferedImage bi = new BufferedImage(diagramView.getSize().width, diagramView.getSize().height, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            diagramView.paint(g);
            g.dispose();
            try {
                File file = fileChooser.getSelectedFile();

                ImageIO.write(bi,"png",file);

                if (!file.getName().endsWith(".png")) {
                    file.renameTo(new File(file.getPath() + ".png"));
                }
            }catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
