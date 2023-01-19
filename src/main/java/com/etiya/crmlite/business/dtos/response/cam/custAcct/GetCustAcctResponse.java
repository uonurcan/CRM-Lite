package com.etiya.crmlite.business.dtos.response.cam.custAcct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCustAcctResponse {
    private Long custAcctId;

    private Long custId;

    private String acctNo;

    private String acctName;

    private Long stId;

    private Long acctTpId;

    private String descr;
}
