package com.tarunawahyudi.restful.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;

    private String username;

    private String password;

    private String name;

    private String token;

    private Long tokenExpiredAt;
}
