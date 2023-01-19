package com.etiya.crmlite.business.dtos.response.product.cmpg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCmpgResponse {
    private Long cmpgId;
    private String name;
    private String descr;
    private String cmpgCode;
    private LocalDate actvtEdate;
    private Long stId;
    private Long isPenalty;
}
