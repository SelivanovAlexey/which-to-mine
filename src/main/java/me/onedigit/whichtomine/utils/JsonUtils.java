package me.onedigit.whichtomine.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

@UtilityClass
public class JsonUtils {

    @SneakyThrows
    public static <T> T readValue(ObjectMapper mapper, JsonNode node, TypeReference<T> type){
        return mapper
                .readerFor(type)
                .readValue(node);
    }
}
