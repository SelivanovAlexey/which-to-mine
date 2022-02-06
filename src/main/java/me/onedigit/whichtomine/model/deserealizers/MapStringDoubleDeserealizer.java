package me.onedigit.whichtomine.model.deserealizers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

//TODO: generify
public class MapStringDoubleDeserealizer extends JsonDeserializer<Map<String, Double>> {

    @Override
    public Map<String, Double> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(p.getText(), new TypeReference<>() {});
    }
}
