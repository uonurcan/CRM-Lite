package com.etiya.crmlite.entities.concretes.order;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "BSN_INTER_SPEC")
public class BsnInterSpec extends BaseEntity {
    @Id
    @SequenceGenerator(name = "bsnInterSpecSeq", sequenceName = "BSN_INTER_SPEC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bsnInterSpecSeq")
    @Column(name = "BSN_INTER_SPEC_ID")
    private Long bsnInterSpecId;

    @ManyToOne
    @JoinColumn(name="BSN_INTER_TP_ID")
    private BsnInterTp bsnInterTp;

    @ManyToOne
    @JoinColumn(name = "PRNT_BSN_INTER_SPEC_ID")
    private BsnInterSpec prntBsnInterSpec;

    @OneToMany(mappedBy = "prntBsnInterSpec")
    private List<BsnInterSpec> childBsnInterSpecs;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "SHRT_CODE")
    private String shrtCode;

    @Column(name = "IS_ACTV")
    private Long isActv;

    @OneToMany(mappedBy = "bsnInterSpec")
    private List<BsnInter> bsnInterList;

    @OneToMany(mappedBy = "bsnInterSpec")
    private List<BsnInterItem> bsnInterItemList;
}
