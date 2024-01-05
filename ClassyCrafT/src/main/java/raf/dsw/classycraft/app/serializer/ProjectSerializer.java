package raf.dsw.classycraft.app.serializer;

import com.google.gson.*;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProjectSerializer implements JsonSerializer<Project>, JsonDeserializer<Project> {
    @Override
    public JsonElement serialize(Project project, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();

        result.add("name", new JsonPrimitive(project.getName()));
        result.add("path", new JsonPrimitive(project.getFilePath()));

        //da li treba serijalizacija za autora
        JsonArray children = new JsonArray();

        for (ClassyNode classyNode : project.getChildren()) {
            children.add(jsonSerializationContext.serialize(classyNode, Package.class));
        }

        result.add("children", children);

        return result;
    }

    @Override
    public Project deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String name = jsonObject.get("name").getAsString();
        String path = jsonObject.get("path").getAsString();

        ArrayList<ClassyNode> children = new ArrayList<>();

        Project project = new Project();
        project.setName(name);
        project.setFilePath(path);



        for (JsonElement element : jsonObject.getAsJsonArray("children")) {
            children.add(jsonDeserializationContext.deserialize(element, Package.class));
        }


        project.setChildren(children);

        return project;
    }
}
