package com.etiya.crmlite.business.dtos.request.cam.custAcct;

import com.etiya.crmlite.business.dtos.request.cam.addr.CreateAddrRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCustAcctRequest {
    private Long custId;
    private String acctName;
    private String descr;
    private String cityName;
    private String addrDesc;
    private String bldgName;
    private String strtName;
}
