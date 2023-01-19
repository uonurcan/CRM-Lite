package com.etiya.crmlite.business.dtos.response.product.prodCharVal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProdCharValResponse {
    private Long prodCharValId;

    private Long prodId;

    private Long gnlCharId;

    private Long gnlCharValId;

    private String Val;

    private Long stId;
}
