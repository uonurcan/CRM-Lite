package com.etiya.crmlite.business.dtos.request.cam.addr;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateAddrRequest {
    private Long addrId;
    private String cityName;
    private String strtName;
    private String bldgName;
    private String addrDesc;
}
