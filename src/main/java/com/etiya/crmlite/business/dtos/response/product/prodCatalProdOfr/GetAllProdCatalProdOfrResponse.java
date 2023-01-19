package com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr;

import com.etiya.crmlite.entities.concretes.product.ProdCatal;
import com.etiya.crmlite.entities.concretes.product.ProdOfr;
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
public class GetAllProdCatalProdOfrResponse {
    private Long prodCatalProdOfrId;

    private Long prodCatalId;

    private Long prodOfrId;

    private Long stId;
}
