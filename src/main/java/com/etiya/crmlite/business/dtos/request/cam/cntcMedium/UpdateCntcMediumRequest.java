package com.etiya.crmlite.business.dtos.request.cam.cntcMedium;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCntcMediumRequest {
    private Long cntcMediumId;
    private Long rowId;
    private Long dataTpId;
    private String cntcData;
    private Long stId;
    private Long cntcMediumTpId;
}

