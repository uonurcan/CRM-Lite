package com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProdCatalProdOfrResponse {
    private Long prodCatalProdOfrId;

    private Long prodCatalId;

    private Long prodOfrId;

    private Long stId;
}
