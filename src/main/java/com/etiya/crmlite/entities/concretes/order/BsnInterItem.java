package com.etiya.crmlite.entities.concretes.order;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BSN_INTER_ITEM")
public class BsnInterItem extends BaseEntity {
    @Id
    @SequenceGenerator(name = "bsnInterItemSeq", sequenceName = "BSN_INTER_ITEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bsnInterItemSeq")
    @Column(name = "BSN_INTER_ITEM_ID")
    private Long bsnInterItemId;

    @ManyToOne
    @JoinColumn(name="BSN_INTER_ID")
    private BsnInter bsnInter;

    @ManyToOne
    @JoinColumn(name = "BSN_INTER_SPEC_ID")
    private BsnInterSpec bsnInterSpec;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "ROW_ID")
    private Long rowId;

    @Column(name = "DATA_TP_ID")
    private Long dataTpId;

    @Column(name = "ACTN_TP_ID")
    private Long actnTpId;

    @Column(name = "ST_ID")
    private Long stId;
}
