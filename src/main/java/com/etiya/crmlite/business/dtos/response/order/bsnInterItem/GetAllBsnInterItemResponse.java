package com.etiya.crmlite.business.dtos.response.order.bsnInterItem;

import com.etiya.crmlite.entities.concretes.order.BsnInter;
import com.etiya.crmlite.entities.concretes.order.BsnInterSpec;
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
public class GetAllBsnInterItemResponse {
    private Long bsnInterItemId;


    private Long bsnInterId;


    private Long bsnInterSpecId;


    private String descr;


    private Long rowId;


    private Long dataTpId;


    private Long actnTpId;


    private Long stId;

}
