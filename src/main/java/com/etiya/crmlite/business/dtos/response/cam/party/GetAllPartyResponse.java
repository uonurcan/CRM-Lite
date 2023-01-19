package com.etiya.crmlite.business.dtos.response.cam.party;

import com.etiya.crmlite.entities.concretes.cam.Ind;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllPartyResponse {
    private Long partyId;

    private Long partyTpId;

    private Long stId;


}
