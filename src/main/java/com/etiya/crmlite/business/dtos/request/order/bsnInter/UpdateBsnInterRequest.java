package com.etiya.crmlite.business.dtos.request.order.bsnInter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateBsnInterRequest {
    private Long bsnInterSpeId;


    private Long custId;


    private String descr;


    private Long bsnInterStId;


    private Long prntBsnInterId;


    private Long rowId;


    private Long dataTpId;
}
