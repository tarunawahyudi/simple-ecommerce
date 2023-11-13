package com.tarunawahyudi.restful.repository;

import com.tarunawahyudi.restful.entity.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private String query;

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(User user) {
        query = "INSERT INTO users (username, password, name) VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                query,
                user.getUsername(),
                user.getPassword(),
                user.getName()
        );
    }

    @Override
    public Boolean existsUsername(String username) {
        query = "SELECT COUNT(*) FROM users WHERE username = ?";
        Integer count = jdbcTemplate.queryForObject(query, Integer.class, username);
        return count != null && count > 0;
    }

    @Override
    public List<User> getAll() {
        query = "SELECT * FROM users";
        return jdbcTemplate.query(
                query,
                new BeanPropertyRowMapper<>(User.class)
        );
    }

    @Override
    public User getById(int id) {
        query = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(
                query,
                new BeanPropertyRowMapper<>(User.class), id
        );
    }

    @Override
    public int update(User user, int id) {
        query = "UPDATE users SET name = ?, username = ?, password = ? WHERE id = ?";
        return jdbcTemplate.update(
                query,
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                id
        );
    }

    @Override
    public int delete(int id) {
        query = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }

    @Override
    public int deleteAll() {
        query = "TRUNCATE users";
        return jdbcTemplate.update(query);
    }

    @Override
    public User findById(String username) {
        query = "SELECT * FROM users WHERE username = ?";
        List<User> users = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class), username);

        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            throw new EmptyResultDataAccessException(1);
        }
    }
}
