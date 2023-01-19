package com.etiya.crmlite.business.dtos.response.cam.ind;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetIndResponse {
    private Long ındId;

    private Long partyId;

    private String frstName;

    private String mName;

    private String lstName;

    private LocalDate brthDate;

    private Long gendrId;

    private String mthrName;

    private String fthrName;

    private Long natId;

    private Long stId;
}
