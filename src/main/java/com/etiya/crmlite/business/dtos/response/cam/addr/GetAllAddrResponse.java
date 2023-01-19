package com.etiya.crmlite.business.dtos.response.cam.addr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllAddrResponse {

    private Long addrId;

    private Long rowId;

    private Long dataTpId;

    private Long strtId;

    private Long bldgId;

    private String addrDesc;

    private Long isActv;

    private String cityName;

    private String strtName;

    private String bldgName;

    private String cntryName;
}
