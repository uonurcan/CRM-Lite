package com.etiya.crmlite.repository.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.cust.GetAllCustResponse;
import com.etiya.crmlite.business.dtos.response.cam.cust.SearchCustResponse;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.entities.concretes.cam.Ind;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ICustRepository extends JpaRepository<Cust,Long> {

    @Query("SELECT DISTINCT new com.etiya.crmlite.business.dtos.response.cam.cust.SearchCustResponse(i.natId," +
            " c.custId, prt.name, i.frstName, i.mName, i.lstName)" +
            "FROM Party p JOIN p.ind i JOIN p.partyRoleList pr JOIN  pr.custList c JOIN  pr.partyRoleTp prt " +
            "LEFT JOIN c.custAcctList ca " +
            "LEFT JOIN CustOrd co on co.custId = c.custId " +
            "LEFT JOIN CntcMedium cm on (cm.rowId = p.partyId and cm.dataTpId = 9 and cm.cntcMediumTpId = 172) " +
            "LEFT JOIN CntcMedium cm2 on (cm.rowId = ca.custAcctId and cm.dataTpId = 13 and cm.cntcMediumTpId = 172) " +
            "where(:nationalityId is null or i.natId =:nationalityId)" +
            "and(:customerId is null or c.custId =:customerId)" +
            "and(:accountNumber is null or ca.acctNo =:accountNumber)" +
            "and(:gsmNumber is null or cm2.cntcData=:gsmNumber or cm.cntcData =:gsmNumber  )" +
            "and(:firstName is null or  lower(i.frstName) LIKE CONCAT(lower(:firstName) ,'%'))" +
            "and(:orderNumber is null or co.custOrdId =:orderNumber)" +
            "and(:lastName is null or lower(i.lstName) LIKE CONCAT(lower(:lastName),'%'))")
    List<SearchCustResponse> findCustBySearchFilters(@Param("nationalityId") Long natId,
                                                          @Param("customerId") Long custId,
                                                          @Param("accountNumber") String acctNumber,
                                                          @Param("gsmNumber") String gsmNumber,
                                                          @Param("firstName") String frstName,
                                                          @Param("lastName") String lstName,
                                                          @Param("orderNumber") Long ordrNumber);

    @Query("select new com.etiya.crmlite.business.dtos.response.cam.cust.GetAllCustResponse" +
            "(c.custId,pr.partyRoleId, c.stId, ct.custTpId)" +
            " from Cust c join c.partyRole pr join c.custTp ct")
    Page<List<GetAllCustResponse>> getAllWithPagination(Pageable pageable);

    @Query("select i from Ind i join i.party p join p.partyRoleList prl join prl.custList cl where cl.custId =:id")
    Ind getIndByCustId(Long id);
}
