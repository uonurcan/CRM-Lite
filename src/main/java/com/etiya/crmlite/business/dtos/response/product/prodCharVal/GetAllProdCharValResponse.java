package com.etiya.crmlite.business.dtos.response.product.prodCharVal;

import com.etiya.crmlite.entities.concretes.common.GnlChar;
import com.etiya.crmlite.entities.concretes.common.GnlCharVal;
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
public class GetAllProdCharValResponse {

    private Long prodCharValId;

    private Long prodId;

    private Long charId;

    private Long charValId;

    private String Val;

    private Long stId;


}
