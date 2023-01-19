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
@Table(name = "BSN_INTER")
public class BsnInter extends BaseEntity {
    @Id
    @SequenceGenerator(name = "bsnInterSeq", sequenceName = "BSN_INTER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bsnInterSeq")
    @Column(name = "BSN_INTER_ID")
    private Long bsnInterId;

    @ManyToOne
    @JoinColumn(name = "BSN_INTER_SPEC_ID")
    private BsnInterSpec bsnInterSpec;

    @Column(name = "CUST_ID")
    private Long custId;

    @Column(name = "DESCR")
    private String descr;

    @ManyToOne
    @JoinColumn(name="BSN_INTER_ST_ID")
    private BsnInterSt bsnInterSt;

    @ManyToOne
    @JoinColumn(name = "PRNT_BSN_INTER_ID")
    private BsnInter prntBsnInter;

    @Column(name = "ROW_ID")
    private Long rowId;

    @Column(name = "DATA_TP_ID")
    private Long dataTpId;

    @OneToMany(mappedBy = "bsnInter")
    private List<CustOrdItem> custOrdItemList;

    @OneToMany(mappedBy = "bsnInter")
    private List<BsnInterItem> bsnInterItemList;
}
