package com.etiya.crmlite.business.dtos.response.common.gnlSt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllGnlStResponse {
    private Long gnlStId;


    private String name;


    private String descr;


    private String shrtCode;


    private Long isActv;


    private String entCodeName;


    private String entName;
}
