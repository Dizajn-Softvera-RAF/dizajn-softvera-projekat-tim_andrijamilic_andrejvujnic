package raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.classContet;

public abstract class ClassContent {
    private String vidljivost;
    private String naziv;

    public ClassContent(String vidljivost, String naziv) {
        this.naziv = naziv;
        this.vidljivost = vidljivost;
    }

    public String toString() {
        return this.vidljivost + " " + this.naziv;
    }
}
