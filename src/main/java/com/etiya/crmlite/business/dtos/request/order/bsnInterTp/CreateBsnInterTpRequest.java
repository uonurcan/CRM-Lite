package com.etiya.crmlite.business.dtos.request.order.bsnInterTp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBsnInterTpRequest {
    private Long prntBsnInterTpId;


    private String name;


    private String descr;


    private String shrtCode;


    private Long isActv;
}
