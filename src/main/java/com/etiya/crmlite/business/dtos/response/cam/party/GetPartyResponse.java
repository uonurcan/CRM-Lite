package com.etiya.crmlite.business.dtos.response.cam.party;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetPartyResponse {
    private Long partyId;

    private Long partyTpId;

    private Long stId;
}
