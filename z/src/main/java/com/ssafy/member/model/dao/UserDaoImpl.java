package com.ssafy.member.model.dao;

import com.ssafy.member.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<UserDto> userMapper = new RowMapper<UserDto>() {
        @Override
        public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserDto user = new UserDto();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setRole(rs.getString("role"));
            return user;
        }
    };

    @Override
    public UserDto getUserById(String id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, userMapper, id);
    }

    @Override
    public int registerUser(UserDto user) {
        String sql = "INSERT INTO users (id, password, name, email, role) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getId(), user.getPassword(), user.getName(), user.getEmail(), user.getRole());
    }

    @Override
    public int updateUser(UserDto user) {
        String sql = "UPDATE users SET password = ?, name = ?, email = ?, role = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getPassword(), user.getName(), user.getEmail(), user.getRole(), user.getId());
    }

    @Override
    public int deleteUser(String id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public UserDto loginUser(String id, String password) {
        String sql = "SELECT * FROM users WHERE id = ? AND password = ?";
        List<UserDto> users = jdbcTemplate.query(sql, userMapper, id, password);
        return users.isEmpty() ? null : users.get(0);
    }
}
