package raf.dsw.classycraft.app.messanger;

import lombok.ToString;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Message {
    private MessageType type;
    private String tekst;
    private Timestamp vreme;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH.mm");

    public Message(MessageType type, String tekst, Timestamp vreme) {
        this.type = type;
        this.tekst = tekst;
        this.vreme = vreme;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + "[" + sdf.format(vreme) + "] " + tekst + ".";
    }
}
