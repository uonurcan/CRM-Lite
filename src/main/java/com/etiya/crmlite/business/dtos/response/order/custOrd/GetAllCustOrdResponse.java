package com.etiya.crmlite.business.dtos.response.order.custOrd;

import com.etiya.crmlite.entities.concretes.order.CustOrdCharVal;
import com.etiya.crmlite.entities.concretes.order.CustOrdItem;
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
public class GetAllCustOrdResponse {
    private Long custOrdId;


    private Long ordStId;


    private Long custId;


}

