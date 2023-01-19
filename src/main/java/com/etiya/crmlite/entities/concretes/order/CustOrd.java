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
@Table(name = "CUST_ORD")
public class CustOrd extends BaseEntity {
    @Id
    @SequenceGenerator(name = "custOrdSeq", sequenceName = "CUST_ORD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custOrdSeq")
    @Column(name = "CUST_ORD_ID")
    private Long custOrdId;

    @Column(name = "ORD_ST_ID")
    private Long ordStId;

    @Column(name = "CUST_ID")
    private Long custId;

    @Column(name = "BSN_INTER_ID")
    private Long bsnInterId;

    @Column(name = "BSN_INTER_SPEC_ID")
    private Long bsnInterSpecId;

    @OneToMany(mappedBy = "custOrd")
    private List<CustOrdItem> custOrdItemList;

    @OneToMany(mappedBy = "custOrd")
    private List<CustOrdCharVal> custOrdCharValList;
}
