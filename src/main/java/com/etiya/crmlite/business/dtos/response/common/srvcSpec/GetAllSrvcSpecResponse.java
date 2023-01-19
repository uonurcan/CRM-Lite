package com.etiya.crmlite.business.dtos.response.common.srvcSpec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllSrvcSpecResponse {
    private Long srvcSpecId;


    private String name;

    private String descr;

    private String srvcCode;

    private Long stId;
}
