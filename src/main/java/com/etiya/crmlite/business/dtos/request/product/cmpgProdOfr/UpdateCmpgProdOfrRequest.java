package com.etiya.crmlite.business.dtos.request.product.cmpgProdOfr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCmpgProdOfrRequest {
    private Long cmpgId;

    private Long prodOfrId;

    private String prodOfrName;

    private int prio;

    private LocalDate sDate;

    private LocalDate eDate;

    private int isActv;
}
