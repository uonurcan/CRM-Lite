package com.etiya.crmlite.business.dtos.request.common.srvcSpec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateSrvcSpecRequest {
    private String name;

    private String descr;

    private String srvcCode;

    private Long stId;
}
