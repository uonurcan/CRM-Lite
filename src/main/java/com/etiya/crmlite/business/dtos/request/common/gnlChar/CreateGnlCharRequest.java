package com.etiya.crmlite.business.dtos.request.common.gnlChar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateGnlCharRequest {
    private String name;

    private String descr;

    private String prvdrCls;

    private String shrtCode;

    private Long isActv;
}
