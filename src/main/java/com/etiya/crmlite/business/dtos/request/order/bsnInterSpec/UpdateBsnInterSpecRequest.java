package com.etiya.crmlite.business.dtos.request.order.bsnInterSpec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateBsnInterSpecRequest {
    private Long bsnInterTpId;


    private Long bsnInterSpecId;


    private String name;


    private String descr;

    private String shrtCode;


    private Long isActv;
}
