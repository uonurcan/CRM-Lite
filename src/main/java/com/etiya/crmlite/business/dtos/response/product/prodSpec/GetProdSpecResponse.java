package com.etiya.crmlite.business.dtos.response.product.prodSpec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProdSpecResponse {
    private Long prodSpecId;

    private String name;

    private String descr;

    private Long stId;

    private Long IsDev;
}
