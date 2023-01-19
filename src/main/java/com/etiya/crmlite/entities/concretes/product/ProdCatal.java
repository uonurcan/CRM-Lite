package com.etiya.crmlite.entities.concretes.product;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROD_CATAL")
public class ProdCatal extends BaseEntity {
    @Id
    @SequenceGenerator(name = "prodCatalSeq", sequenceName = "PROD_CATAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodCatalSeq")
    @Column(name = "PROD_CATAL_ID")
    private Long prodCatalId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "ST_ID")
    private Long stId;

    @Column(name = "SHRT_CODE")
    private String shrtCode;

    @OneToMany(mappedBy = "prodCatal")
    private List<ProdCatalProdOfr> prodCatalProdOfrList;
}
