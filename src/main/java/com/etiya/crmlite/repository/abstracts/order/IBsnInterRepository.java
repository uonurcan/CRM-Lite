package com.etiya.crmlite.repository.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetAllBsnInterResponse;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.entities.concretes.order.BsnInter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBsnInterRepository extends JpaRepository<BsnInter,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.order.bsnInter.GetAllBsnInterResponse" +
            "(bi.bsnInterId, bis.bsnInterSpecId, bi.custId, bi.descr, bist.bsnInterStId, bi.rowId, bi.dataTpId) " +
            "from BsnInter bi join bi.bsnInterSpec bis join bi.bsnInterSt bist")
    Page<List<GetAllBsnInterResponse>> getAllWithPagination(Pageable pageable);

    @Query("Select p from Party p JOIN p.partyRoleList pr JOIN pr.custList c Where c.custId=:custId ")
    Party findPartyByCustId(@Param("custId") Long custId);
}

