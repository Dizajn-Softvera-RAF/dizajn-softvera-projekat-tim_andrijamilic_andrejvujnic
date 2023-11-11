package raf.dsw.classycraft.app.messanger;

import lombok.ToString;

import java.lang.reflect.Type;
import java.sql.Timestamp;

public class Message {
    private MessageType type;
    private String tekst;
    private Timestamp vreme;

    public Message(MessageType type, String tekst, Timestamp vreme) {
        this.type = type;
        this.tekst = tekst;
        this.vreme = vreme;
    }

    @Override
    public String toString() {
        return "[" + type + "]" + "[" + vreme + "]" + tekst;
    }
}
