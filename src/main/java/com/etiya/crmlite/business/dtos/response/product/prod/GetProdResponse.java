package com.etiya.crmlite.business.dtos.response.product.prod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProdResponse {
    private Long prodId;

    private Long prntProdId;

    private Long prodOfrId;

    private Long prodSpecId;

    private String name;

    private String descr;

    private Long trnscId;

    private Long cmpgId;

    private Long stId;
}
