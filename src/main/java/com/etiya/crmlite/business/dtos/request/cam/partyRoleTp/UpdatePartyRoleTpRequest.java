package com.etiya.crmlite.business.dtos.request.cam.partyRoleTp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePartyRoleTpRequest {
    private Long partyRoleTpId;
    private String name;
    private String descr;
    private String shrtCode;
    private Long isActv;
}
