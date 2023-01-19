package com.etiya.crmlite.business.dtos.response.product.prodOfr;

import com.etiya.crmlite.entities.concretes.product.CmpgProdOfr;
import com.etiya.crmlite.entities.concretes.product.Prod;
import com.etiya.crmlite.entities.concretes.product.ProdCatalProdOfr;
import com.etiya.crmlite.entities.concretes.product.ProdSpec;
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
public class GetAllProdOfrResponse {

    private Long prodOfrId;

    private Long prodSpecId;

    private String name;

    private String descr;

    private Long prntOfrId;

    private Long stId;

    private Long prodOfrTotalPrc;

}
