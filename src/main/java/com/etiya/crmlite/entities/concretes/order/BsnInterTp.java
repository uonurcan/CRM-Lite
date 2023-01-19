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
@Table(name = "BSN_INTER_TP")
public class BsnInterTp extends BaseEntity {
    @Id
    @SequenceGenerator(name = "bsnInterTpSeq", sequenceName = "BSN_INTER_TP_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bsnInterTpSeq")
    @Column(name = "BSN_INTER_TP_ID")
    private Long bsnInterTpId;

    @ManyToOne
    @JoinColumn(name = "PRNT_BSN_INTER_TP_ID")
    private BsnInterTp prntBsnInterTp;

    @OneToMany(mappedBy = "prntBsnInterTp")
    private List<BsnInterTp> childBsnInterTps;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "SHRT_CODE")
    private String shrtCode;

    @Column(name = "IS_ACTV")
    private Long isActv;

    @OneToMany(mappedBy = "bsnInterTp")
    private List<BsnInterSpec> bsnInterSpecList;
}
