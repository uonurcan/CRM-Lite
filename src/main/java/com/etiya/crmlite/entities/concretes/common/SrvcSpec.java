package com.etiya.crmlite.entities.concretes.common;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.product.ProdSpecSrvcSpec;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SRVC_SPEC")
public class SrvcSpec extends BaseEntity {
    @Id
    @SequenceGenerator(name = "srvcSpecSeq", sequenceName = "SRVC_SPEC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "srvcSpecSeq")
    @Column(name = "SRVC_SPEC_ID")
    private Long srvcSpecId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "SRVC_CODE")
    private String srvcCode;

    @Column(name = "ST_ID")
    private Long stId;

    @OneToMany(mappedBy = "srvcSpec")
    private List<ProdSpecSrvcSpec> prodSpecSrvcSpecList;
}