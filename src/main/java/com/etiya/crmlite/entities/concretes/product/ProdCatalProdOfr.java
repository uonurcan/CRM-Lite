package com.etiya.crmlite.entities.concretes.product;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROD_CATAL_PROD_OFR")
public class ProdCatalProdOfr extends BaseEntity {
    @Id
    @SequenceGenerator(name = "prodCatalProdOfrSeq", sequenceName = "PROD_CATAL_PROD_OFR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodCatalProdOfrSeq")
    @Column(name = "PROD_CATAL_PROD_OFR_ID")
    private Long prodCatalProdOfrId;

    @ManyToOne
    @JoinColumn (name ="PROD_CATAL_ID")
    private ProdCatal prodCatal;

    @ManyToOne
    @JoinColumn (name ="PROD_OFR_ID")
    private ProdOfr prodOfr;

    @Column(name = "ST_ID")
    private Long stId;
}
