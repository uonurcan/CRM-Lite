package com.etiya.crmlite.business.dtos.response.order.bsnInter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetBsnInterResponse {
    private Long bsnInterId;


    private Long bsnInterSpecId;


    private Long custId;


    private String descr;


    private Long bsnInterStId;


    private Long prntBsnInterId;


    private Long rowId;


    private Long dataTpId;
}
