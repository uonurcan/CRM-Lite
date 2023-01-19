package com.etiya.crmlite.business.dtos.response.cam.cust;

import com.etiya.crmlite.entities.concretes.cam.CustTp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCustResponse {
    private Long custId;

    private Long partyRoleId;

    private Long stId;

    private Long custTpId;
}
