package me.onedigit.whichtomine.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
public class DeviceDto {
    String name;
    Type type;
    Integer power;
    Map<String, Double> hashrates;
    Boolean isRumor;
    Boolean isLhr;

}
