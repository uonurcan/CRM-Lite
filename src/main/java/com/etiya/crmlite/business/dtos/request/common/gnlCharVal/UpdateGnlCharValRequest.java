package com.etiya.crmlite.business.dtos.request.common.gnlCharVal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateGnlCharValRequest {
    private Long charId;


    private Long isDflt;

    private String val;

    private String shrtCode;


    private LocalDate sDate;


    private LocalDate eDate;

    private Long isActv;
}
