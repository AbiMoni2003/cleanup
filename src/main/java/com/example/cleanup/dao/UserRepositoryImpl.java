package com.example.cleanup.dao;

import com.example.cleanup.entity.User;
import com.example.cleanup.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findInactiveUsers(LocalDateTime thresholdDate) {
        String sql = "SELECT * FROM users WHERE last_login_date < ?";
        return jdbcTemplate.query(sql, new Object[]{thresholdDate}, 
            (rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setLastLoginDate(rs.getTimestamp("last_login_date").toLocalDateTime());
                return user;
            });
    }

    @Override
    public void deleteUserById(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
