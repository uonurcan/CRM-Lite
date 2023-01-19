package com.etiya.crmlite.entities.concretes.product;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.common.GnlChar;
import com.etiya.crmlite.entities.concretes.common.GnlCharVal;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROD_CHAR_VAL")
public class ProdCharVal extends BaseEntity {
    @Id
    @SequenceGenerator(name = "prodCharValSeq", sequenceName = "PROD_CHAR_VAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodCharValSeq")
    @Column(name = "PROD_CHAR_VAL_ID")
    private Long prodCharValId;

    @ManyToOne
    @JoinColumn(name = "PROD_ID")
    private Prod prod;

    @ManyToOne
    @JoinColumn(name = "CHAR_ID")
    private GnlChar gnlChar;

    @ManyToOne
    @JoinColumn(name = "CHAR_VAL_ID")
    private GnlCharVal gnlCharVal;

    @Column(name = "VAL")
    private String val;

    @Column(name = "ST_ID")
    private Long stId;
}
