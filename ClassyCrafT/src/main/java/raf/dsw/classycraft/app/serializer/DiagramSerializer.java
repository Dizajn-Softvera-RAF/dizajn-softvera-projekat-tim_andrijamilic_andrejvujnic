package raf.dsw.classycraft.app.serializer;

import com.google.gson.*;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DiagramSerializer implements JsonSerializer<Diagram>, JsonDeserializer<Diagram> {
    @Override
    public JsonElement serialize(Diagram diagram, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.add("class", new JsonPrimitive(diagram.getClass().getSimpleName()));
        result.add("name", new JsonPrimitive(diagram.getName()));

        JsonArray models = new JsonArray();
        for (ClassyNode model : diagram.getChildren()) {
            models.add(jsonSerializationContext.serialize(model));
        }
        // stavimo user
        result.add("models", models);
        result.add("template", new JsonPrimitive(diagram.isTemplate()));
        return result;
    }

    @Override
    public Diagram deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String name = jsonObject.get("name").getAsString();
        boolean template = jsonObject.get("template").getAsBoolean();

        ArrayList<ClassyNode> models = new ArrayList<>();

        System.out.println("diagram serializeer");
        for (JsonElement element : jsonObject.getAsJsonArray("models")) {
            System.out.println(element);
            models.add(jsonDeserializationContext.deserialize(element, DiagramElement.class));
        }

        Diagram diagram = new Diagram();
        diagram.setName(name);
        diagram.setTemplate(template);
        diagram.setChildren(models);

        return diagram;
    }
}
