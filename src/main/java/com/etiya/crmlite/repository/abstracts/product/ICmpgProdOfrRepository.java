package com.etiya.crmlite.repository.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr.GetAllCmpgProdOfrResponse;
import com.etiya.crmlite.entities.concretes.product.CmpgProdOfr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICmpgProdOfrRepository extends JpaRepository<CmpgProdOfr,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr.GetAllCmpgProdOfrResponse" +
            "(cpo.cmpgProdOfrId,c.cmpgId, po.prodOfrId, cpo.prodOfrName,  cpo.prio, cpo.sDate, cpo.eDate, cpo.isActv)" +
            " from CmpgProdOfr cpo join cpo.cmpg c join cpo.prodOfr po")

    Page<List<GetAllCmpgProdOfrResponse>> getAllWithPagination(Pageable pageable);
}
