package com.etiya.crmlite.business.dtos.response.order.custOrd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCustOrdResponse {
    private Long custOrdId;


    private Long ordStId;


    private Long custId;
}
