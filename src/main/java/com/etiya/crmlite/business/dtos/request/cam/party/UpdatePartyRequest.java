package com.etiya.crmlite.business.dtos.request.cam.party;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePartyRequest {
    private Long partyId;
    private Long partyTpId;
    private Long stId;
    private Long indId;
}
