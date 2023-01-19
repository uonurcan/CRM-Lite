package com.etiya.crmlite.business.dtos.response.common.gnlTp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllGnlTpResponse {

    private Long gnlTpId;


    private String name;


    private String descr;


    private String shrtCode;


    private String entCodeName;


    private String entName;


    private Long isActv;
}

