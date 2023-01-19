package com.etiya.crmlite.business.dtos.request.cam.custAcct;

import com.etiya.crmlite.business.dtos.request.cam.addr.CreateAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.addr.UpdateAddrRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCustAcctRequest {
    private Long custAcctId;
    private String acctName;
    private String descr;
    private UpdateAddrRequest updateAddrRequest;
}
