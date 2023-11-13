package com.tarunawahyudi.restful.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletResponse {

    private String name;

    private Integer balance;

    private Integer userId;
}
