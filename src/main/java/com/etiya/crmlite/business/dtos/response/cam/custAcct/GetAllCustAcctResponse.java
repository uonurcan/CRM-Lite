package com.etiya.crmlite.business.dtos.response.cam.custAcct;

import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.entities.concretes.cam.CustAcctProdInvl;
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
public class GetAllCustAcctResponse {
    private Long custAcctId;

    private Long custId;

    private String acctNo;

    private String acctName;

    private Long stId;

    private Long acctTpId;

    private String descr;

}
