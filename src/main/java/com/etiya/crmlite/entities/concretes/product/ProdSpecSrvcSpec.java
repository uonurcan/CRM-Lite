package com.etiya.crmlite.entities.concretes.product;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.common.SrvcSpec;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROD_SPEC_SRVC_SPEC")
public class ProdSpecSrvcSpec extends BaseEntity {
    @Id
    @SequenceGenerator(name = "prodSpecSrvcSpecSeq", sequenceName = "PROD_SPEC_SRVC_SPEC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodSpecSrvcSpecSeq")
    @Column(name = "PROD_SPEC_SRVC_SPEC_ID")
    private Long prodSpecSrvcSpecId;

    @ManyToOne
    @JoinColumn(name = "PROD_SPEC_ID")
    private ProdSpec prodSpec;

    @ManyToOne
    @JoinColumn(name = "SRVC_SPEC_ID")
    private SrvcSpec srvcSpec;

    @Column(name = "REL_TP_ID")
    private Long relTpId;

    @Column(name = "SDATE")
    private LocalDate sDate;

    @Column(name = "EDATE")
    private LocalDate eDate;

    @Column(name = "ST_ID")
    private Long stId;
}
