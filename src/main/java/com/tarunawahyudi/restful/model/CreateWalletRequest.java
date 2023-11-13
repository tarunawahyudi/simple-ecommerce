package com.tarunawahyudi.restful.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateWalletRequest {

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @Positive
    private Integer balance;

    @NotNull
    private Integer UserId;
}
