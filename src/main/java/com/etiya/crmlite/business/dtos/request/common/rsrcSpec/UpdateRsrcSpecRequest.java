package com.etiya.crmlite.business.dtos.request.common.rsrcSpec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateRsrcSpecRequest {
    private String name;

    private String descr;

    private Long stId;

    private String rsrcCode;
}
