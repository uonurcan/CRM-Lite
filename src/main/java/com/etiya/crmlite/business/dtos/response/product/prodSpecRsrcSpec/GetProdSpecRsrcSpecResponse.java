package com.etiya.crmlite.business.dtos.response.product.prodSpecRsrcSpec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProdSpecRsrcSpecResponse {
    private Long prodSpecRsrcSpecId;

    private Long prodSpecId;

    private Long rsrcSpecId;

    private Long relTpId;

    private LocalDate sDate;

    private LocalDate eDate;

    private Long stId;
}
