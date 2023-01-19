package com.etiya.crmlite.repository.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.custOrdCharVal.GetAllCustOrdCharValResponse;
import com.etiya.crmlite.entities.concretes.order.CustOrdCharVal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustOrdCharValRepository extends JpaRepository<CustOrdCharVal,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.order.custOrdCharVal." +
            "GetAllCustOrdCharValResponse(cocv.custOrdCharValId," +
            "co.custOrdId, cocv.charId, cocv.charValId, cocv.val, cocv.isActv) " +
            "from CustOrdCharVal cocv join cocv.custOrd co")
    Page<List<GetAllCustOrdCharValResponse>> getAllWithPagination(Pageable pageable);
}
