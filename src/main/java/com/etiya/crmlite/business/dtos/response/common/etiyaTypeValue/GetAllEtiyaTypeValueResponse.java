package com.etiya.crmlite.business.dtos.response.common.etiyaTypeValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllEtiyaTypeValueResponse {

    private Long typeValueId;


    private String tableName;


    private String description;

    private String value;

    private String usingModuleName;
}
