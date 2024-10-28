package com.ssafy.member.model.dao;

import com.ssafy.member.model.ResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceDaoImpl implements ResourceDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SELECT_ALL_RESOURCES = "SELECT * FROM resources";
    private final String SELECT_RESOURCE_BY_ID = "SELECT * FROM resources WHERE resource_id = ?";

    @Override
    public List<ResourceDto> getAllResources() {
        return jdbcTemplate.query(SELECT_ALL_RESOURCES, new BeanPropertyRowMapper<>(ResourceDto.class));
    }

    @Override
    public ResourceDto getResourceById(int resourceId) {
        return jdbcTemplate.queryForObject(
            SELECT_RESOURCE_BY_ID, 
            new Object[]{resourceId}, 
            new BeanPropertyRowMapper<>(ResourceDto.class)
        );
    }
}
