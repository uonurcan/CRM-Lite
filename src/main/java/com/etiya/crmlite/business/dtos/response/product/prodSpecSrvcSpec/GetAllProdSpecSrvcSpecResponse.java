package com.etiya.crmlite.business.dtos.response.product.prodSpecSrvcSpec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllProdSpecSrvcSpecResponse {
    private Long prodSpecSrvcSpecId;

    private Long prodSpecId;

    private Long srvcSpecId;

    private Long relTpId;

    private LocalDate sDate;

    private LocalDate eDate;

    private Long stId;
}
