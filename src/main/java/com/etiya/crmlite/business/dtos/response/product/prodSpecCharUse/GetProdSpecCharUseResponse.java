package com.etiya.crmlite.business.dtos.response.product.prodSpecCharUse;

import com.etiya.crmlite.entities.concretes.common.GnlChar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProdSpecCharUseResponse {
    private Long prodSpecCharUseId;

    private Long prodSpecId;

    private Long gnlCharId;

    private String name;

    private String descr;

    private Long isActv;
}
