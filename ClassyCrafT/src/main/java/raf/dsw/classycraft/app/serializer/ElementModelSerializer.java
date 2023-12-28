package raf.dsw.classycraft.app.serializer;

import com.google.gson.*;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ElementModelSerializer implements JsonSerializer<DiagramElement>, JsonDeserializer<DiagramElement> {

    @Override
    public JsonElement serialize(DiagramElement diagramElement, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("class", new JsonPrimitive(diagramElement.getClass().getSimpleName()));
        jsonObject.add("color", jsonSerializationContext.serialize(diagramElement.getBoja()));
        jsonObject.add("stroke", new JsonPrimitive(diagramElement.getStroke()));
        if (diagramElement instanceof InterClass) {
            InterClass interClass = (InterClass) diagramElement;
            jsonObject.add("name", new JsonPrimitive(interClass.getName()));
            jsonObject.add("coordinates", jsonSerializationContext.serialize(interClass.getPosition()));

        }
        return jsonObject;
    }

    @Override
    public DiagramElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.get("class") == null) return null;

        Color color = jsonDeserializationContext.deserialize(jsonObject.get("color"), Color.class);
        int stroke = jsonObject.get("stroke").getAsInt();

        String className = jsonObject.get("class").getAsString();
        if (className.equals("PojamModel")) {
            String name = jsonObject.get("name").getAsString();
            Point coords = jsonDeserializationContext.deserialize(jsonObject.get("coordinates"), Point.class);
            Dimension dimension = jsonDeserializationContext.deserialize(jsonObject.get("size"), Dimension.class);

        }
        return null;
    }
}


