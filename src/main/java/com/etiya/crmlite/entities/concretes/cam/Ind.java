package com.etiya.crmlite.entities.concretes.cam;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "IND")
public class Ind extends BaseEntity {
    @Id
    @SequenceGenerator(name = "indSeq", sequenceName = "IND_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "indSeq")
    @Column(name = "IND_ID")
    private Long indId;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "PARTY_ID", referencedColumnName = "PARTY_ID")
    private Party party;

    @Column(name = "FRST_NAME")
    private String frstName;

    @Column(name = "MNAME")
    private String mName;

    @Column(name = "LST_NAME")
    private String lstName;

    @Column(name = "BRTH_DATE")
    private LocalDate brthDate;

    @Column(name = "GENDR_ID")
    private Long gendrId;

    @Column(name = "MTHR_NAME")
    private String mthrName;

    @Column(name = "FTHR_NAME")
    private String fthrName;

    @Column(name = "NAT_ID")
    private Long natId;

    @Column(name = "ST_ID")
    private Long stId;
}
