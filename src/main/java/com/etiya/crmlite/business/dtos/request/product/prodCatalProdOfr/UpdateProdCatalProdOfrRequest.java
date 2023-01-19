package com.etiya.crmlite.business.dtos.request.product.prodCatalProdOfr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateProdCatalProdOfrRequest {
    private Long prodCatalId;

    private Long prodOfrId;

    private Long stId;
}
