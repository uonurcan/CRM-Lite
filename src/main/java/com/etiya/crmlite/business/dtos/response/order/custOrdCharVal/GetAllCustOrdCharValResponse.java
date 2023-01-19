package com.etiya.crmlite.business.dtos.response.order.custOrdCharVal;

import com.etiya.crmlite.entities.concretes.order.CustOrd;
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
public class GetAllCustOrdCharValResponse {
    private Long custOrdCharValId;

    private Long custOrdId;


    private Long charId;

    private Long charValId;


    private String val;

    private Long isActv;
}
