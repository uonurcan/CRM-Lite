package com.etiya.crmlite.business.dtos.response.product.prodSpec;

import com.etiya.crmlite.entities.concretes.product.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllProdSpecResponse {
    private Long prodSpecId;

    private String name;

    private String descr;

    private Long stId;

    private Long isDev;


}
