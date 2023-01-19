package com.etiya.crmlite.business.dtos.request.product.prodCatal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProdCatalRequest {
    private String name;

    private String descr;

    private Long stId;

    private String shrtCode;
}
