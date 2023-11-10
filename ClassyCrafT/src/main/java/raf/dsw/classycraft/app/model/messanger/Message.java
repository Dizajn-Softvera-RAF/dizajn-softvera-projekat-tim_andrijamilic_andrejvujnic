package raf.dsw.classycraft.app.model.messanger;

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
}
