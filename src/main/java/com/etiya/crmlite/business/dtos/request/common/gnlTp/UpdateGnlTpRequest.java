package com.etiya.crmlite.business.dtos.request.common.gnlTp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateGnlTpRequest {
    private String name;


    private String descr;


    private String shrtCode;


    private String entCodeName;


    private String entName;


    private Long isActv;
}
