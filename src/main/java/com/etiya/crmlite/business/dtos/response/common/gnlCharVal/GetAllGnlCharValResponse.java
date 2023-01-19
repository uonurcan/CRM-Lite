package com.etiya.crmlite.business.dtos.response.common.gnlCharVal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllGnlCharValResponse {
    private Long charValId;


    private Long charId;


    private Long isDflt;

    private String val;

    private String shrtCode;


    private LocalDate sDate;


    private LocalDate eDate;

    private Long isActv;
}
