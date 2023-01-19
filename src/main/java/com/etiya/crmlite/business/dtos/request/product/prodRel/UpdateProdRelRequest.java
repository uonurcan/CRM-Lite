package com.etiya.crmlite.business.dtos.request.product.prodRel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateProdRelRequest {
    private Long prodId1;

    private Long prodId2;

    private Long relTpId;

    private Long isActv;
}
