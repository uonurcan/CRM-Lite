package com.etiya.crmlite.entities.concretes.cam;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ADDR")
public class Addr extends BaseEntity {
    @Id
    @SequenceGenerator(name = "addrSeq", sequenceName = "ADDR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addrSeq")
    @Column(name = "ADDR_ID")
    private Long addrId;

    @Column(name = "ROW_ID")
    private Long rowId;

    @Column(name = "DATA_TP_ID")
    private Long dataTpId;

    @Column(name = "STRT_ID")
    private Long strtId;

    @Column(name = "BLDG_ID")
    private Long bldgId;

    @Column(name = "ADDR_DESC")
    private String addrDesc;

    @Column(name = "IS_ACTV")
    private Long isActv;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "STRT_NAME")
    private String strtName;

    @Column(name = "BLDG_NAME")
    private String bldgName;

    @Column(name = "CNTRY_NAME")
    private String cntryName;
}
