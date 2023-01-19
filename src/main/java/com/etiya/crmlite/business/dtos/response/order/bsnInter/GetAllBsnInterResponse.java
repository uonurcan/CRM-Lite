package com.etiya.crmlite.business.dtos.response.order.bsnInter;

import com.etiya.crmlite.entities.concretes.order.*;
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
public class GetAllBsnInterResponse {
    private Long bsnInterId;


    private Long bsnInterSpecId;


    private Long custId;


    private String descr;


    private Long bsnInterStId;




    private Long rowId;


    private Long dataTpId;


}
