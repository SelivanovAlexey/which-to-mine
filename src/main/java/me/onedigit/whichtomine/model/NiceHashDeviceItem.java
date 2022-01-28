package me.onedigit.whichtomine.model;

import lombok.Value;

@Value
public class NiceHashDeviceItem {
    String id;
    String name;
    String niceName;
    String nhmId;
    String category;
    Integer power;
    String speeds;
    String powers;
    String meta;
    Boolean hidden;
    Integer sortOrder;
    String createdTs;
    String nhFirmware;
    String qmOptions;
    String lockedSpeeds;
    Double paying;
}
