package me.onedigit.whichtomine.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import me.onedigit.whichtomine.model.deserealizers.MapStringBooleanDeserealizer;
import me.onedigit.whichtomine.model.deserealizers.MapStringDoubleDeserealizer;

import java.util.Map;

@Data
@NoArgsConstructor
public class NicehashDeviceItem {
    String id;
    String name;
    String niceName;
    String nhmId;
    String category;
    Integer power;
    @JsonDeserialize(using = MapStringDoubleDeserealizer.class)
    Map<String, Double> speeds;
    String powers;
    @JsonDeserialize(using = MapStringBooleanDeserealizer.class)
    Map<String, Boolean> meta;
    Boolean hidden;
    Integer sortOrder;
    String createdTs;
    String nhFirmware;
    String qmOptions;
    String lockedSpeeds;
    Double paying;
}
