package com.etiya.crmlite.entities.concretes.product;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.cam.CustAcctProdInvl;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROD")
public class Prod extends BaseEntity {
    @Id
    @SequenceGenerator(name = "prodSeq", sequenceName = "PROD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodSeq")
    @Column(name = "PROD_ID")
    private Long prodId;

    @ManyToOne
    @JoinColumn(name = "PRNT_PROD_ID")
    private Prod prntProd;

    @ManyToOne
    @JoinColumn (name = "PROD_OFR_ID")
    private ProdOfr prodOfr;

    @ManyToOne
    @JoinColumn (name = "PROD_SPEC_ID")
    private ProdSpec prodSpec;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "TRNSC_ID")
    private Long trnscId;

    @Column(name = "CMPG_ID")
    private Long cmpgId;

    @Column(name = "ST_ID")
    private Long stId;

    @OneToMany(mappedBy = "prod")
    private List<CustAcctProdInvl> custAcctProdInvlList;

    @OneToMany(mappedBy = "prod1")
    private List<ProdRel> prodRelList;

    @OneToMany(mappedBy = "prod2")
    private List<ProdRel> prodRel2List;

    @OneToMany(mappedBy = "prod")
    private List<ProdCharVal> prodCharValList;
}