package com.etiya.crmlite.business.dtos.request.cam.custTp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCustTpRequest {
    private Long custTpId;
    private String name;
    private String descr;
    private Long partyTpId;
    private String shrtCode;
    private Long isActv;
}
