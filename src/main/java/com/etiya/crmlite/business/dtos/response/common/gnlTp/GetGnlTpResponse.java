package com.etiya.crmlite.business.dtos.response.common.gnlTp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetGnlTpResponse {
    private Long gnlTpId;


    private String name;


    private String descr;


    private String shrtCode;


    private String entCodeName;


    private String entName;


    private Long isActv;
}
