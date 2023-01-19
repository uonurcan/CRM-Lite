package com.etiya.crmlite.business.dtos.request.cam.addr;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateAddrRequest {
    private String addrDesc;
    private String cityName;
    private String strtName;
    private String bldgName;
    private Long rowId;
}
