package com.etiya.crmlite.business.dtos.request.common.etiyaTypeValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateEtiyaTypeValueRequest {
    private String tableName;


    private String description;

    private String value;

    private String usingModuleName;
}
