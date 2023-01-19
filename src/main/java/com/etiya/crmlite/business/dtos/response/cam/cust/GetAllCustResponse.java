package com.etiya.crmlite.business.dtos.response.cam.cust;

import com.etiya.crmlite.entities.concretes.cam.CustAcct;
import com.etiya.crmlite.entities.concretes.cam.CustTp;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllCustResponse {
    private Long custId;

    private Long partyRoleId;

    private Long stId;

    private Long custTpId;
}
