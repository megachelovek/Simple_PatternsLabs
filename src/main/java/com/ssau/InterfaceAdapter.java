package com.ssau;

import com.google.gson.*;

import java.lang.reflect.Type;

public class InterfaceAdapter implements JsonSerializer, JsonDeserializer {

    private static final String CLASSNAME = "CLASSNAME";
    private static final String DATA = "DATA";

    public Student deserialize(JsonElement jsonElement, Type type,JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
        String className = prim.getAsString();
        Class klass = getObjectClass(className);
        return jsonDeserializationContext.deserialize(jsonObject.get(DATA), klass);
    }

    @Override
    public JsonElement serialize(Object o, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CLASSNAME, jsonObject.getClass().getName());
        jsonObject.add(DATA, jsonSerializationContext.serialize(jsonObject));
        return jsonObject;
    }

    /****** Helper method to get the className of the object to be deserialized *****/
    public Class getObjectClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e.getMessage());
        }
    }


}
