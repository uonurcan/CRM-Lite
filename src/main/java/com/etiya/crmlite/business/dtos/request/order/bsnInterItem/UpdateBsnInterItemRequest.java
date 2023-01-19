package com.etiya.crmlite.business.dtos.request.order.bsnInterItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateBsnInterItemRequest {
    private Long bsnInterId;


    private Long bsnInterSpecId;


    private String descr;


    private Long rowId;


    private Long dataTpId;


    private Long actnTpId;


    private Long stId;
}
