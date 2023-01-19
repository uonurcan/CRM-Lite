package com.etiya.crmlite.business.dtos.request.product.prodOfr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProdOfrRequest {
    private Long prodSpecId;

    private String name;

    private String descr;

    private Long prntOfrId;

    private Long stId;

    private Long prodOfrTotalPrc;
}
