package com.etiya.crmlite.business.dtos.request.product.prod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateProdRequest {
    private Long prntProdId;

    private Long prodOfrId;

    private Long prodSpecId;

    private String name;

    private String descr;

    private Long trnscId;

    private Long cmpgId;

    private Long stId;
}
