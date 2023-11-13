package com.tarunawahyudi.restful.repository;

import com.tarunawahyudi.restful.entity.Product;
import com.tarunawahyudi.restful.entity.User;

import java.util.List;

public interface UserRepository {

    int save(User user);
    Boolean existsUsername(String username);

    List<User> getAll();

    User getById(int id);

    int update(User user, int id);

    int delete(int id);

    int deleteAll();

    User findById(String username);
}
