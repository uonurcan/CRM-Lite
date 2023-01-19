package com.etiya.crmlite.business.dtos.request.product.prodSpecCharUse;

import com.etiya.crmlite.entities.concretes.common.GnlChar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProdSpecCharUseRequest {
    private Long prodSpecId;

    private GnlChar gnlChar;

    private String name;

    private String descr;

    private Long isActv;
}
