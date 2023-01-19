package com.etiya.crmlite.business.dtos.response.product.prodSpecRsrcSpec;

import com.etiya.crmlite.entities.concretes.common.RsrcSpec;
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
public class GetAllProdSpecRsrcSpecResponse {
    private Long prodSpecRsrcSpecId;

    private Long prodSpecId;

    private Long rsrcSpecId;

    private Long relTpId;

    private LocalDate sDate;

    private LocalDate eDate;

    private Long stId;
}
