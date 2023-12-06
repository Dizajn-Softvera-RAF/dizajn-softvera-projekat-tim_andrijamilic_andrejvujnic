package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTree;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImpl;
import raf.dsw.classycraft.app.messanger.Message;
import raf.dsw.classycraft.app.messanger.MessageType;
import raf.dsw.classycraft.app.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter

public class MainFrame extends JFrame implements ISubscriber {

    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private static MainFrame instance;
    private ClassyTree classyTree;
    private JSplitPane split;


    //buduca polja za sve komponente view-a na glavnom prozoru


    private void initialise()
    {
        actionManager = new ActionManager();
        classyTree = new ClassyTreeImpl();
        initialiseGui();
    }

    private void initialiseGui(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ClassyCrafT");

        menu = new MyMenyBar();
        setJMenuBar(menu);

        toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);

        JPanel desktop=new JPanel();
        desktop.setBackground(Color.WHITE);

        JTree projectExplorer = classyTree.generateTree(ApplicationFramework.getInstance().getClassyRepository().getProjectExplorer());

        JScrollPane scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        /*JSplitPane*/ split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);

    }

    private MainFrame(){

    }
    public static MainFrame getInstance()
    {
        if(instance == null)
        {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Message){
            if(((Message) notification).getType().equals(MessageType.WARNING)){
                JOptionPane.showMessageDialog(this, notification, "Warning", JOptionPane.WARNING_MESSAGE);
            }else if(((Message) notification).getType().equals(MessageType.ERROR)){
                JOptionPane.showMessageDialog(this, notification, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
