package com.etiya.crmlite.business.dtos.response.order.custOrdItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCustOrdItemResponse {
    private Long custOrdItemId;


    private Long custOrdId;


    private Long custAcctId;


    private Long newCustAcctId;


    private Long prodId;


    private Long prodOfrId;


    private Long bsnInterId;


    private Long cmpgId;


    private Long isNeedShptm;


    private String ofrName;


    private String prodName;


    private Long prodSpecId;


    private Long custId;


    private Long newCustId;


    private String cmpgName;
}
