package com.etiya.crmlite.business.dtos.request.common.gnlSt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateGnlStRequest {
    private String name;


    private String descr;


    private String shrtCode;


    private Long isActv;


    private String entCodeName;


    private String entName;
}
