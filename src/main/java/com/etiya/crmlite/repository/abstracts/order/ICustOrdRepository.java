package com.etiya.crmlite.repository.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.custOrd.GetAllCustOrdResponse;
import com.etiya.crmlite.entities.concretes.order.CustOrd;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustOrdRepository extends JpaRepository<CustOrd,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.order.custOrd.GetAllCustOrdResponse" +
            "(co.custOrdId, co.ordStId, co.custId) from CustOrd co")
    Page<List<GetAllCustOrdResponse>> getAllWithPagination(Pageable pageable);
}
