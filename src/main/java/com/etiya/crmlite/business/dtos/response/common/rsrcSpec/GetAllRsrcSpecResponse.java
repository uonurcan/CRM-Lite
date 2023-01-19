package com.etiya.crmlite.business.dtos.response.common.rsrcSpec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllRsrcSpecResponse {
    private Long rsrcSpecId;


    private String name;

    private String descr;

    private Long stId;

    private String rsrcCode;
}
