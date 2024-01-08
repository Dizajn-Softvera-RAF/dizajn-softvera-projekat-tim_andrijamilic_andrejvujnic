package raf.dsw.classycraft.app.serializer;

import com.google.gson.*;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Enum;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Interface;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.Klasa;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Agregacija;
import raf.dsw.classycraft.app.gui.swing.painter.connectionPainter.AgregacijaPainter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.EnumPainter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.InterfejsPainter;
import raf.dsw.classycraft.app.gui.swing.painter.interClassPainter.KlasaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

import java.awt.*;
import java.lang.reflect.Type;

public class DiagramElementSerializer implements JsonSerializer<DiagramElement>, JsonDeserializer<DiagramElement> {

    @Override
    public JsonElement serialize(DiagramElement diagramElement, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("class", new JsonPrimitive(diagramElement.getClass().getSimpleName()));
        jsonObject.add("color", jsonSerializationContext.serialize(diagramElement.getBoja()));
        jsonObject.add("stroke", new JsonPrimitive(diagramElement.getStroke()));

        if (diagramElement instanceof Klasa) {
            Klasa klasa = (Klasa) diagramElement;
            jsonObject.add("name", new JsonPrimitive(klasa.getName()));
            jsonObject.add("coordinates", jsonSerializationContext.serialize(klasa.getPosition()));
            jsonObject.add("size", jsonSerializationContext.serialize(klasa.getSize()));
        }
        else if(diagramElement instanceof Interface)
        {
            Interface interfejs = (Interface) diagramElement;
            jsonObject.add("name", new JsonPrimitive(interfejs.getName()));
            jsonObject.add("coordinates", jsonSerializationContext.serialize(interfejs.getPosition()));
            jsonObject.add("size", jsonSerializationContext.serialize(interfejs.getSize()));
        }
        else if(diagramElement instanceof Enum)
        {
            Enum e = (Enum) diagramElement;
            jsonObject.add("name", new JsonPrimitive(e.getName()));
            jsonObject.add("coordinates", jsonSerializationContext.serialize(e.getPosition()));
            jsonObject.add("size", jsonSerializationContext.serialize(e.getSize()));
        }
        else if(diagramElement instanceof Agregacija)
        {
            Agregacija a = (Agregacija) diagramElement;
            jsonObject.add("name", new JsonPrimitive(a.getName()));
            jsonObject.add("DO", jsonSerializationContext.serialize(a.getDoo().getName()));
            jsonObject.add("OD", jsonSerializationContext.serialize(a.getOd().getName()));
        }
        return jsonObject;
    }

    @Override
    public DiagramElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        if(jsonObject.get("painter") == null || jsonObject.get("painter").getAsJsonObject().get("diagramElement") == null || jsonObject.get("painter").getAsJsonObject().get("diagramElement").getAsJsonObject().get("class") == null) return null;

        jsonObject = jsonObject.get("painter").getAsJsonObject().get("diagramElement").getAsJsonObject();

        Color color = jsonDeserializationContext.deserialize(jsonObject.get("color"), Color.class);
        int stroke = jsonObject.get("stroke").getAsInt();

        String className = jsonObject.get("class").getAsString();
        System.out.println(className);
        if (className.equals("Klasa")) {
            String name = jsonObject.get("name").getAsString();
            Point coords = jsonDeserializationContext.deserialize(jsonObject.get("coordinates"), Point.class);
            Dimension dimension = jsonDeserializationContext.deserialize(jsonObject.get("size"), Dimension.class);

            DiagramView dw = ((PackageView)(MainFrame.getInstance().getSplit().getRightComponent())).getDW();
            Diagram diagram = dw.getDiagram();

            Klasa k = new Klasa(name, diagram, coords);
            KlasaPainter kp = new KlasaPainter(k);
            dw.getDiagram().addChild(k);
            //System.out.println(dw.getDiagram().getChildren());
            dw.getPainters().add(kp);
            k.setPainter(kp);
            return k;
        }
        else if (className.equals("Interface")) {
            String name = jsonObject.get("name").getAsString();
            Point coords = jsonDeserializationContext.deserialize(jsonObject.get("coordinates"), Point.class);
            Dimension dimension = jsonDeserializationContext.deserialize(jsonObject.get("size"), Dimension.class);
            DiagramView dw = ((PackageView)(MainFrame.getInstance().getSplit().getRightComponent())).getDW();
            Diagram diagram = dw.getDiagram();

            Interface i = new Interface(name, diagram, coords);
            InterfejsPainter ip = new InterfejsPainter(i);
            dw.getDiagram().addChild(i);
            //System.out.println(dw.getDiagram().getChildren());
            dw.getPainters().add(ip);
            i.setPainter(ip);
            return i;
        }

        else if (className.equals("Enum")) {
            String name = jsonObject.get("name").getAsString();
            Point coords = jsonDeserializationContext.deserialize(jsonObject.get("coordinates"), Point.class);
            Dimension dimension = jsonDeserializationContext.deserialize(jsonObject.get("size"), Dimension.class);
            DiagramView dw = ((PackageView) (MainFrame.getInstance().getSplit().getRightComponent())).getDW();
            Diagram diagram = dw.getDiagram();

            Enum e = new Enum(name, diagram, coords);
            EnumPainter ep = new EnumPainter(e);
            dw.getDiagram().addChild(e);
            //System.out.println(dw.getDiagram().getChildren());
            dw.getPainters().add(ep);
            e.setPainter(ep);
            return e;
        }
        else if (className.equals("Agregacija")) {
            System.out.println("Agregacija");
            String name = jsonObject.get("name").getAsString();
            InterClass od = jsonDeserializationContext.deserialize(jsonObject.get("OD"), InterClass.class);
            InterClass doo = jsonDeserializationContext.deserialize(jsonObject.get("DO"), InterClass.class);
            DiagramView dw = ((PackageView) (MainFrame.getInstance().getSplit().getRightComponent())).getDW();
            Diagram diagram = dw.getDiagram();
            //System.out.println("Od " + od);
            //System.out.println("Doo " + doo);

            Agregacija agregacija;
            AgregacijaPainter ap;
            DiagramElement diagramElement;

            Agregacija con = new Agregacija("Agregacija", diagram, od, doo);
            agregacija =  con;
            dw.getDiagram().addChild(con);
            ap = new AgregacijaPainter(con);
            dw.getPainters().add(ap);
            con.setPainter(ap);

            return con;
        }
        System.out.println("jeste null");

        return null;
    }
}


