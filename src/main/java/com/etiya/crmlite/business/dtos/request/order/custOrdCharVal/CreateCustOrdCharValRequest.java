package com.etiya.crmlite.business.dtos.request.order.custOrdCharVal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCustOrdCharValRequest {
    private Long custOrdId;


    private Long charId;

    private Long charValId;


    private String val;

    private Long isActv;
}
