package com.etiya.crmlite.business.dtos.response.order.custOrdCharVal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCustOrdCharValResponse {
    private Long custOrdCharValId;

    private Long custOrdId;


    private Long charId;

    private Long charValId;


    private String val;

    private Long isActv;
}

