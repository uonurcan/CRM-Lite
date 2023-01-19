package com.etiya.crmlite.business.dtos.response.product.prodSpecSrvcSpec;

import com.etiya.crmlite.entities.concretes.common.SrvcSpec;
import com.etiya.crmlite.entities.concretes.product.ProdSpec;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProdSpecSrvcSpecResponse {
    private Long prodSpecSrvcSpecId;

    private Long prodSpecId;

    private Long srvcSpecId;

    private Long relTpId;

    private LocalDate sDate;

    private LocalDate eDate;

    private Long stId;
}
