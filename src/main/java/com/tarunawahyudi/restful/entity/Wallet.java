package com.tarunawahyudi.restful.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    private int id;

    private String name;

    private int balance;

    private int userId;

}
