package com.etiya.crmlite.repository.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.custAcct.GetAllCustAcctResponse;
import com.etiya.crmlite.entities.concretes.cam.CustAcct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ICustAcctRepository extends JpaRepository<CustAcct,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.cam.custAcct.GetAllCustAcctResponse" +
            "(ca.custAcctId, c.custId, ca.acctNo, ca.acctName, ca.stId, ca.acctTpId, ca.descr)" +
            " from CustAcct ca inner join ca.cust c")
    Page<List<GetAllCustAcctResponse>> getAllWithPagination(Pageable pageable);


}
