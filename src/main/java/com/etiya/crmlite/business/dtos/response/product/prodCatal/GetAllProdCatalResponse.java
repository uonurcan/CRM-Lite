package com.etiya.crmlite.business.dtos.response.product.prodCatal;

import com.etiya.crmlite.entities.concretes.product.ProdCatalProdOfr;
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
public class GetAllProdCatalResponse {

    private Long prodCatalId;

    private String name;

    private String descr;

    private Long stId;

    private String shrtCode;

}
