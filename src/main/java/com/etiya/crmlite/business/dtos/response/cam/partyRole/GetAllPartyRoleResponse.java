package com.etiya.crmlite.business.dtos.response.cam.partyRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllPartyRoleResponse {
    private Long partyRoleId;

    private Long partyId;

    private Long partyRoleTpId;

    private Long stId;
}
