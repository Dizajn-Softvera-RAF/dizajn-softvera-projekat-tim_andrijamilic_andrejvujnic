package raf.dsw.classycraft.app.classyRepository.implementation.connection;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;

public class Kompozicija extends Connection {
    public Kompozicija(String name, ClassyNode parent, InterClass od, InterClass doo) {

        super(name, parent, od, doo);
    }
}
