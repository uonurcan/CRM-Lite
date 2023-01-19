package com.etiya.crmlite.business.dtos.response.cam.partyRoleTp;

import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllPartyRoleTpResponse {
    private Long partyRoleTpId;

    private String name;

    private String descr;

    private String shrtCode;

    private Long isActv;

}
