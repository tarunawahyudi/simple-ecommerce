package com.tarunawahyudi.restful.repository;

import com.tarunawahyudi.restful.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private String query;

    final
    JdbcTemplate jdbcTemplate;

    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAll() {
        query = "SELECT * FROM products";
        return jdbcTemplate.query(
                query,
                new BeanPropertyRowMapper<>(Product.class)
        );
    }

    @Override
    public Product getById(int id) {
        query = "SELECT * FROM products WHERE id = ?";
        return jdbcTemplate.queryForObject(
                query,
                new BeanPropertyRowMapper<>(Product.class), id
        );
    }

    @Override
    public int save(Product product) {
        query = "INSERT INTO products (name, description, price) VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                query,
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    @Override
    public int update(Product product, int id) {
        query = "UPDATE products SET name = ?, description = ?, price = ? WHERE id = ?";
        return jdbcTemplate.update(
                query,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                id
        );
    }

    @Override
    public int delete(int id) {
        query = "DELETE FROM products WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }

    @Override
    public int deleteAll() {
        query = "TRUNCATE products";
        return jdbcTemplate.update(query);
    }
}