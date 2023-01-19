package com.etiya.crmlite.entities.concretes.order;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUST_ORD_CHAR_VAL")
public class CustOrdCharVal extends BaseEntity {
    @Id
    @SequenceGenerator(name = "custOrdCharValSeq", sequenceName = "CUST_ORD_CHAR_VALSEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custOrdCharValSeq")
    @Column(name = "CUST_ORD_CHAR_VAL_ID")
    private Long custOrdCharValId;

    @ManyToOne
    @JoinColumn(name = "CUST_ORD_ID")
    private CustOrd custOrd;

    @Column(name = "CHAR_ID")
    private Long charId;

    @Column(name = "CHAR_VAL_ID")
    private Long charValId;

    @Column(name = "VAL")
    private String val;

    @Column(name = "IS_ACTV")
    private Long isActv;
}
