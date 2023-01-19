package com.etiya.crmlite.business.dtos.response.product.prodCatal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProdCatalResponse {
    private Long prodCatalId;

    private String name;

    private String descr;

    private Long stId;

    private String shrtCode;
}

