package com.etiya.crmlite.entities.concretes.cam;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","custTp","partyRole","custAcctList" })
@Table(name = "CUST")
public class Cust extends BaseEntity {
    @Id
    @SequenceGenerator(name = "custSeq", sequenceName = "CUST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custSeq")
    @Column(name = "CUST_ID")
    private Long custId;

    @ManyToOne
    @JoinColumn(name = "PARTY_ROLE_ID")
    private PartyRole partyRole;

    @Column(name = "ST_ID")
    private Long stId;

    @ManyToOne
    @JoinColumn(name="CUST_TP_ID")
    private CustTp custTp;


    @OneToMany(mappedBy="cust", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CustAcct> custAcctList;
}
