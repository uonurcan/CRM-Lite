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
@Table(name = "BSN_INTER_ST")
public class BsnInterSt extends BaseEntity {
    @Id
    @SequenceGenerator(name = "bsnInterStSeq", sequenceName = "BSN_INTER_ST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bsnInterStSeq")
    @Column(name = "BSN_INTER_ST_ID")
    private Long bsnInterStId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "SHRT_CODE")
    private String shrtCode;

    @Column(name = "IS_ACTV")
    private Long isActv;

    @OneToMany(mappedBy="bsnInterSt")
    private List<BsnInter> bsnInterList;
}
