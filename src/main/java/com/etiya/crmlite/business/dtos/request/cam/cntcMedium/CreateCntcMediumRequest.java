package com.etiya.crmlite.business.dtos.request.cam.cntcMedium;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCntcMediumRequest {
    private Long rowId;
    private String cntcData;
    private Long cntcMediumTpId;
}

