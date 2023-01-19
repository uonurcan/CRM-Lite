package com.etiya.crmlite.business.dtos.response.common.gnlChar;

import com.etiya.crmlite.entities.concretes.product.ProdCharVal;
import com.etiya.crmlite.entities.concretes.product.ProdSpecCharUse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetGnlCharResponse {
    private Long charId;

    private String name;

    private String descr;

    private String prvdrCls;

    private String shrtCode;

    private Long isActv;


}
