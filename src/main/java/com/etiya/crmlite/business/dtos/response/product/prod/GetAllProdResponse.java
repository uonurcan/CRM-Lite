package com.etiya.crmlite.business.dtos.response.product.prod;

import com.etiya.crmlite.entities.concretes.cam.CustAcctProdInvl;
import com.etiya.crmlite.entities.concretes.product.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class GetAllProdResponse {
    private Long prodId;

    private Long prodOfrId;

    private Long prodSpecId;

    private String name;

    private String descr;

    private Long trnscId;

    private Long cmpgId;

    private Long stId;


}
