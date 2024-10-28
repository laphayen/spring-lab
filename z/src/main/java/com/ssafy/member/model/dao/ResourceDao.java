package com.ssafy.member.model.dao;

import com.ssafy.member.model.ResourceDto;
import java.util.List;

public interface ResourceDao {
    List<ResourceDto> getAllResources();
    ResourceDto getResourceById(int resourceId);
}