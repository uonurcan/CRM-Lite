package com.etiya.crmlite.business.dtos.response.product.prodRel;

import com.etiya.crmlite.entities.concretes.product.Prod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllProdRelResponse {
    private Long prodRelId;

    private Long prodId1;

    private Long prodId2;

    private Long relTpId;

    private Long isActv;


}
