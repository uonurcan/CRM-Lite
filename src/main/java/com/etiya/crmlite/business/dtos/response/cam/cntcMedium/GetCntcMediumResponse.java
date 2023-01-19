package com.etiya.crmlite.business.dtos.response.cam.cntcMedium;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCntcMediumResponse {
    private Long cntcMediumId;

    private Long rowId;

    private Long dataTpId;

    private String cntcData;

    private Long stId;

    private Long cntcMediumTpId;
}
