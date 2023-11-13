package com.tarunawahyudi.restful.repository;

import com.tarunawahyudi.restful.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();

    Product getById(int id);

    int save(Product product);

    int update(Product product, int id);

    int delete(int id);

    int deleteAll();

}
