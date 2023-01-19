package com.etiya.crmlite.repository.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetAllCustAcctProdInvlResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlFromACustResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlResponse;
import com.etiya.crmlite.entities.concretes.cam.CustAcctProdInvl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustAcctProdInvlRepository extends JpaRepository<CustAcctProdInvl, Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetAllCustAcctProdInvlResponse" +
            "(capi.custAcctProdInvlId, ca.custAcctId, p.prodId, capi.shrtCode, capi.stId)" +
            " from CustAcctProdInvl capi inner join capi.custAcct ca inner join capi.prod p")
    Page<List<GetAllCustAcctProdInvlResponse>> getAllWithPagination(Pageable pageable);

    @Query("Select new com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlResponse" +
            "(capi.custAcctProdInvlId, capi.custAcct.custAcctId, capi.prod.prodId, capi.shrtCode, capi.stId) "+
            "FROM CustAcctProdInvl capi "+
            "JOIN CustAcct ca ON ca.custAcctId = capi.custAcct.custAcctId "+
            "JOIN Cust c ON c.custId = ca.cust.custId "+
            "WHERE c.custId = :custId AND capi.stId = 9010")
    List<GetCustAcctProdInvlResponse> getActvProdOfCust(@Param("custId") Long custId);

    @Query( "Select new com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlFromACustResponse(capi.prod.prodId,p.name,cp.name,cpo.cmpg.cmpgId) "+
            " FROM CustAcctProdInvl  capi " +
            "JOIN CustAcct ca ON ca.custAcctId = capi.custAcct.custAcctId " +
            "JOIN Prod p ON p.prodId= capi.prod.prodId " +
            "JOIN ProdOfr po ON po.prodOfrId=p.prodOfr.prodOfrId "+
            "JOIN CmpgProdOfr cpo ON cpo.prodOfr.prodOfrId =po.prodOfrId "+
            "JOIN Cmpg cp ON cp.cmpgId = cpo.cmpg.cmpgId "+
            " WHERE ca.custAcctId = :custAcctId")
    List<GetCustAcctProdInvlFromACustResponse> getActvProdOfBillAcct(@Param("custAcctId") Long custAcctId);


}