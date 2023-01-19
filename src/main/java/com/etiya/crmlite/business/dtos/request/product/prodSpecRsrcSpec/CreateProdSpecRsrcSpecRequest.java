package com.etiya.crmlite.business.dtos.request.product.prodSpecRsrcSpec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProdSpecRsrcSpecRequest {
    private Long prodSpecId;

    private Long rsrcSpecId;

    private Long relTpId;

    private LocalDate sDate;

    private LocalDate eDate;

    private Long stId;
}
