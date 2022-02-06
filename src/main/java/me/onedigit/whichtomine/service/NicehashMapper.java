package me.onedigit.whichtomine.service;

import me.onedigit.whichtomine.common.mapping.Mapper;
import me.onedigit.whichtomine.model.dto.DeviceDto;
import me.onedigit.whichtomine.model.NicehashDeviceItem;
import me.onedigit.whichtomine.model.dto.Type;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NicehashMapper extends Mapper<NicehashDeviceItem, DeviceDto> {

    public NicehashMapper() {
        rule(NicehashDeviceItem::getName, DeviceDto::setName);
        rule(NicehashDeviceItem::getCategory, (d, type) -> d.setType(Type.valueOf(type)));
        rule(NicehashDeviceItem::getPower, DeviceDto::setPower);
        rule(NicehashDeviceItem::getSpeeds, DeviceDto::setHashrates);

        rule(nhdi -> Optional.ofNullable(nhdi)
                .map(NicehashDeviceItem::getMeta)
                .map(map -> map.get("lhr")).orElse(false), DeviceDto::setIsLhr);

        rule(nhdi -> Optional.ofNullable(nhdi)
                .map(NicehashDeviceItem::getMeta)
                .map(map -> map.get("rumor")).orElse(false), DeviceDto::setIsRumor);
    }
}
