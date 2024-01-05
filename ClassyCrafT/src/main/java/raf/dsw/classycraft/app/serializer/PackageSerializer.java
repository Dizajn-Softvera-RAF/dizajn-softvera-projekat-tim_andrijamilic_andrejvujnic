package raf.dsw.classycraft.app.serializer;

import com.google.gson.*;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class PackageSerializer implements JsonSerializer<Package>, JsonDeserializer<Package> {
    @Override
    public JsonElement serialize(Package pcg, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();

        result.add("name", new JsonPrimitive(pcg.getName()));
        result.add("parent", new JsonPrimitive(String.valueOf(pcg.getParent())));

        JsonArray children = new JsonArray();

        for (ClassyNode classyNode : pcg.getChildren()) {
            children.add(jsonSerializationContext.serialize(classyNode, Diagram.class));
        }

        result.add("children", children);

        return result;
    }

    @Override
    public Package deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String name = jsonObject.get("name").getAsString();
        String parent = jsonObject.get("parent").getAsString();

        ArrayList<ClassyNode> children = new ArrayList<>();

        Package p = new Package();
        p.setName(name);

        for (JsonElement element : jsonObject.getAsJsonArray("children")) {
            children.add(jsonDeserializationContext.deserialize(element, Diagram.class));
        }


        p.setChildren(children);

        return p;
    }
}
