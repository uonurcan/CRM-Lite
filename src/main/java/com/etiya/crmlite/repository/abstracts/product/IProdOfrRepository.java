package com.etiya.crmlite.repository.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodOfr.GetAllProdOfrResponse;
import com.etiya.crmlite.entities.concretes.product.ProdOfr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProdOfrRepository extends JpaRepository<ProdOfr,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.product.prodOfr.GetAllProdOfrResponse" +
            "(po.prodOfrId, ps.prodSpecId,po.name, po.descr, po.prntOfrId, po.stId, po.prodOfrTotalPrc)" +
            " from ProdOfr po  inner join po.prodSpec ps")
    Page<List<GetAllProdOfrResponse>> getAllWithPagination(Pageable pageable);
}
