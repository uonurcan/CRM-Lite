package com.etiya.crmlite.business.dtos.response.order.bsnInterTp;

import com.etiya.crmlite.entities.concretes.order.BsnInterSpec;
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
public class GetAllBsnInterTpResponse {
    private Long bsnInterTpId;


    private String name;


    private String descr;


    private String shrtCode;


    private Long isActv;



}
