package com.etiya.crmlite.business.dtos.request.product.prodCharVal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateProdCharValRequest {
    private Long prodId;

    private Long gnlCharId;

    private Long gnlCharValId;

    private String Val;

    private Long stId;
}
