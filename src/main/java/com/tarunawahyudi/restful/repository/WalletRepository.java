package com.tarunawahyudi.restful.repository;

import com.tarunawahyudi.restful.entity.Product;
import com.tarunawahyudi.restful.entity.Wallet;

import java.util.List;

public interface WalletRepository {

    List<Wallet> getAll();

    Wallet getById(int id);

    int save(Wallet wallet);

    int update(Wallet wallet, int id);

    int delete(int id);

    int deleteAll();
}
