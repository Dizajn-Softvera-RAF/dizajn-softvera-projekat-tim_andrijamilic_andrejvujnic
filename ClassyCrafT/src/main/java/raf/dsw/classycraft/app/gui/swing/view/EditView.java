//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package raf.dsw.classycraft.app.gui.swing.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.controller.action.DodajKontetAction;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTree;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImpl;

public class EditView extends JFrame {
    private JButton bt1;
    private JButton bt2;
    private ClassyTree classyTree;
    private ActionManager actionManager;
    private JLabel tekst;
    private JTextField textField;
    private JComboBox<String> jComboBox;
    private JComboBox<String> izbor;
    private int x;
    private int y;
    private DiagramView dw;
    private MouseEvent event;

    public EditView(int x, int y, DiagramView dw, MouseEvent event) {
        this.x = x;
        this.y = y;
        this.dw = dw;
        this.event = event;
        this.initialise();
    }

    private void initialise() {
        this.actionManager = new ActionManager();
        this.classyTree = new ClassyTreeImpl();
        this.initialiseGui();
    }

    private void initialiseGui() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setSize(screenWidth / 2, screenHeight / 2);
        this.setLocationRelativeTo((Component)null);
        this.setTitle("Option");
        this.tekst = new JLabel("Edit je otvoren");
        this.bt1 = new JButton();
        this.bt2 = new JButton(new DodajKontetAction(this.x, this.y, this.dw, this.event, this));
        String[] s = new String[]{"none", "private", "public", "protected"};
        String[] s1 = new String[]{"none", "metoda", "atribut"};
        this.izbor = new JComboBox(s1);
        this.jComboBox = new JComboBox(s);
        this.textField = new JTextField();
        this.bt1.setText("Obrisi");
        this.bt2.setText("Dodaj");
        JPanel panel = new JPanel();
        this.setSize(500, 500);
        panel.add(this.tekst);
        panel.add(new JLabel("Izaberi metodu ili polje"));
        panel.add(this.izbor);
        panel.add(new JLabel("Vidljivost"));
        panel.add(this.jComboBox);
        panel.add(new JLabel("Potpis metode bez vidljivosti"));
        panel.add(this.textField);
        panel.add(this.bt1);
        panel.add(this.bt2);
        panel.setLayout(new BoxLayout(panel, 1));
        this.add(panel);
        panel.setVisible(true);
    }

    public JButton getBt1() {
        return this.bt1;
    }

    public JButton getBt2() {
        return this.bt2;
    }

    public ClassyTree getClassyTree() {
        return this.classyTree;
    }

    public ActionManager getActionManager() {
        return this.actionManager;
    }

    public JLabel getTekst() {
        return this.tekst;
    }

    public JTextField getTextField() {
        return this.textField;
    }

    public JComboBox<String> getJComboBox() {
        return this.jComboBox;
    }

    public JComboBox<String> getIzbor() {
        return this.izbor;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public DiagramView getDw() {
        return this.dw;
    }

    public MouseEvent getEvent() {
        return this.event;
    }

    public void setBt1(JButton bt1) {
        this.bt1 = bt1;
    }

    public void setBt2(JButton bt2) {
        this.bt2 = bt2;
    }

    public void setClassyTree(ClassyTree classyTree) {
        this.classyTree = classyTree;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public void setTekst(JLabel tekst) {
        this.tekst = tekst;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public void setJComboBox(JComboBox<String> jComboBox) {
        this.jComboBox = jComboBox;
    }

    public void setIzbor(JComboBox<String> izbor) {
        this.izbor = izbor;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDw(DiagramView dw) {
        this.dw = dw;
    }

    public void setEvent(MouseEvent event) {
        this.event = event;
    }
}
