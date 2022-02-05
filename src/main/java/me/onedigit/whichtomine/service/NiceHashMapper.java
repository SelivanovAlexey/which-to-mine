package me.onedigit.whichtomine.service;

import me.onedigit.whichtomine.common.mapping.Mapper;
import me.onedigit.whichtomine.model.dto.DeviceDto;
import me.onedigit.whichtomine.model.NiceHashDeviceItem;
import org.springframework.stereotype.Service;

@Service
public class NiceHashMapper extends Mapper<NiceHashDeviceItem, DeviceDto> {

    public NiceHashMapper() {
        // TODO: there should be a set of rules for mapping
    }
}
