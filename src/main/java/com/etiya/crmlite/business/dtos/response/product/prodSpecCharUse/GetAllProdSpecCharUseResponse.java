package com.etiya.crmlite.business.dtos.response.product.prodSpecCharUse;

import com.etiya.crmlite.entities.concretes.common.GnlChar;
import com.etiya.crmlite.entities.concretes.product.ProdSpec;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllProdSpecCharUseResponse {
    private Long prodSpecCharUseId;

    private Long prodSpecId;

    private Long charId;

    private String name;

    private String descr;

    private Long isActv;

}
