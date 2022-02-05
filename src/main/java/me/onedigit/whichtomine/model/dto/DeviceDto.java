package me.onedigit.whichtomine.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceDto {
    String name;
    Type type;
    Integer power;
    Map<String, Double> hashrates;
    Boolean isRumor;
    Boolean isLhr;
}
