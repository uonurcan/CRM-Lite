package com.etiya.crmlite.business.dtos.request.order.custOrd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCustOrdRequest {
    private Long ordStId;


    private Long custId;
}
