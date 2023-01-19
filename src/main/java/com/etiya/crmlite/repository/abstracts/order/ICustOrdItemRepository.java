package com.etiya.crmlite.repository.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.custOrdItem.GetAllCustOrdItemResponse;
import com.etiya.crmlite.entities.concretes.order.CustOrdItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustOrdItemRepository extends JpaRepository<CustOrdItem,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.order.custOrdItem.GetAllCustOrdItemResponse" +
            "(coi.custOrdItemId, co.custOrdId, coi.custAcctId, coi.newCustAcctId, coi.prodId," +
            "coi.prodOfrId, bi.bsnInterId, coi.cmpgId, coi.isNeedShptm, coi.ofrName, coi.prodName," +
            "coi.prodSpecId, coi.custId, coi.newCustId, coi.cmpgName) " +
            "from CustOrdItem coi join coi.custOrd co join coi.bsnInter bi")
    Page<List<GetAllCustOrdItemResponse>> getAllWithPagination(Pageable pageable);
}
