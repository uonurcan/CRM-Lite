package com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCmpgProdOfrResponse {
    private Long cmpgProdOfrId;


    private Long cmpgId;


    private Long prodOfrId;


    private String prodOfrName;


    private Long prio;


    private LocalDate sDate;

    private LocalDate eDate;

    private Long isActv;
}
