package com.etiya.crmlite.business.dtos.request.product.prodSpec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateProdSpecRequest {
    private String name;

    private String descr;

    private Long stId;

    private Long IsDev;
}
