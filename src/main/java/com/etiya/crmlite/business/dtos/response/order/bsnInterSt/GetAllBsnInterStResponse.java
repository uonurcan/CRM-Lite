package com.etiya.crmlite.business.dtos.response.order.bsnInterSt;

import com.etiya.crmlite.entities.concretes.order.BsnInter;
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
public class GetAllBsnInterStResponse {
    private Long bsnInterStId;


    private String name;


    private String descr;


    private String shrtCode;


    private Long isActv;


}
