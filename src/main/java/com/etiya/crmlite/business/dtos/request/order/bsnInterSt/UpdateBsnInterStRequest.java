package com.etiya.crmlite.business.dtos.request.order.bsnInterSt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateBsnInterStRequest {



    private String name;


    private String descr;


    private String shrtCode;


    private Long isActv;
}
