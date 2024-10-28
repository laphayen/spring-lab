package com.ssafy.member.model.service;

import com.ssafy.member.model.ResourceDto;
import java.util.List;

public interface ResourceService {
    List<ResourceDto> getAllResources();
    ResourceDto getResourceById(int resourceId);
}
