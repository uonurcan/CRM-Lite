package com.etiya.crmlite.entities.concretes.product;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROD_SPEC")
public class ProdSpec extends BaseEntity {
    @Id
    @SequenceGenerator(name = "prodSpecSeq", sequenceName = "PROD_SPEC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodSpecSeq")
    @Column(name = "PROD_SPEC_ID")
    private Long prodSpecId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "ST_ID")
    private Long stId;

    @Column(name = "IS_DEV")
    private Long isDev;

    @OneToMany(mappedBy ="prodSpec")
    @JsonIgnore
    private List<ProdOfr> prodOfrList;

    @OneToMany(mappedBy ="prodSpec")
    private List<Prod> prodList;

    @OneToMany(mappedBy ="prodSpec")
    private List<ProdSpecCharUse> prodSpecCharUseList;

    @OneToMany(mappedBy ="prodSpec")
    private List<ProdSpecRsrcSpec> prodSpecRsrsSpecList;

    @OneToMany(mappedBy ="prodSpec")
    private List<ProdSpecSrvcSpec> prodSpecSrvcSpecList;
}
