package com.etiya.crmlite.business.dtos.request.cam.custAcctProdInvl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCustAcctProdInvlRequest {
    private Long custAcctProdInvlId;
    private Long custAcctId;
    private Long prodId;
    private String shrtCode;
    private Long stId;
}
