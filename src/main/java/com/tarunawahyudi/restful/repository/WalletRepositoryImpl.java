package com.tarunawahyudi.restful.repository;

import com.tarunawahyudi.restful.entity.User;
import com.tarunawahyudi.restful.entity.Wallet;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WalletRepositoryImpl implements WalletRepository {

    private String query;

    private final JdbcTemplate jdbcTemplate;

    public WalletRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Wallet> getAll() {
        query = "SELECT * FROM wallets";
        return jdbcTemplate.query(
                query,
                new BeanPropertyRowMapper<>(Wallet.class)
        );
    }

    @Override
    public Wallet getById(int id) {
        query = "SELECT * FROM wallets WHERE id = ?";
        return jdbcTemplate.queryForObject(
                query,
                new BeanPropertyRowMapper<>(Wallet.class), id
        );
    }

    @Override
    public int save(Wallet wallet) {
        query = "INSERT INTO wallets (name, balance, user_id) VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                query,
                wallet.getName(),
                wallet.getBalance(),
                wallet.getUserId()
        );
    }

    @Override
    public int update(Wallet wallet, int id) {
        query = "UPDATE wallets SET name = ?, balance = ?, user_id = ? WHERE id = ?";
        return jdbcTemplate.update(
                query,
                wallet.getName(),
                wallet.getBalance(),
                wallet.getUserId(),
                id
        );
    }

    @Override
    public int delete(int id) {
        query = "DELETE FROM wallets WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }

    @Override
    public int deleteAll() {
        query = "TRUNCATE wallets";
        return jdbcTemplate.update(query);
    }
}
