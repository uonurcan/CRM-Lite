package com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCustAcctProdInvlFromACustResponse {
    private Long prodId;
    private String prodName;
    private String cmpgName;
    private Long cmpgId;
}
