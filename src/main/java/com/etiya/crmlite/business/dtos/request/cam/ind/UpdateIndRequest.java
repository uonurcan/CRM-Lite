package com.etiya.crmlite.business.dtos.request.cam.ind;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateIndRequest {
    private Long indId;
    private Long party;
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
