package com.etiya.crmlite.business.dtos.response.order.bsnInterSpec;

import com.etiya.crmlite.entities.concretes.order.BsnInter;
import com.etiya.crmlite.entities.concretes.order.BsnInterItem;
import com.etiya.crmlite.entities.concretes.order.BsnInterSpec;
import com.etiya.crmlite.entities.concretes.order.BsnInterTp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllBsnInterSpecResponse {
    private Long bsnInterSpecId;


    private Long bsnInterTpId;




    private String name;


    private String descr;

    private String shrtCode;


    private Long isActv;



}
