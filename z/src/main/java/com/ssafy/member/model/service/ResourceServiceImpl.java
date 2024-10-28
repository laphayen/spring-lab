package com.ssafy.member.model.service;

import com.ssafy.member.model.ResourceDto;
import com.ssafy.member.model.dao.ResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<ResourceDto> getAllResources() {
        return resourceDao.getAllResources();
    }

    @Override
    public ResourceDto getResourceById(int resourceId) {
        return resourceDao.getResourceById(resourceId);
    }
}
