package com.etiya.crmlite.business.dtos.request.cam.partyRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePartyRoleRequest {
    private Long partyId;

    private Long partyRoleTpId;

    private Long stId;
}

