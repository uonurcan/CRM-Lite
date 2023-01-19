package com.etiya.crmlite.business.dtos.response.order.bsnInterSt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetBsnInterStResponse {
    private Long bsnInterStId;


    private String name;


    private String descr;


    private String shrtCode;


    private Long isActv;
}
