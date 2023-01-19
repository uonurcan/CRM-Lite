package com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr;

import com.etiya.crmlite.entities.concretes.product.Cmpg;
import com.etiya.crmlite.entities.concretes.product.ProdOfr;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllCmpgProdOfrResponse {
    private Long cmpgProdOfrId;

    private Long cmpgId;

    private Long prodOfrId;

    private String prodOfrName;

    private Long prio;

    private LocalDate sDate;

    private LocalDate eDate;

    private Long isActv;
}
