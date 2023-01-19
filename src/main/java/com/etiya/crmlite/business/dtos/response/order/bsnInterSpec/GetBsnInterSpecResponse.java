package com.etiya.crmlite.business.dtos.response.order.bsnInterSpec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetBsnInterSpecResponse {
    private Long bsnInterSpecId;


    private Long bsnInterTpId;


    private Long prntBsnInterSpecId;


    private String name;


    private String descr;

    private String shrtCode;


    private Long isActv;
}
