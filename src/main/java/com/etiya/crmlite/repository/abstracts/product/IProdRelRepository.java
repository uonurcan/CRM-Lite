package com.etiya.crmlite.repository.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodRel.GetAllProdRelResponse;
import com.etiya.crmlite.entities.concretes.product.ProdRel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProdRelRepository extends JpaRepository<ProdRel,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.product.prodRel.GetAllProdRelResponse" +
            "(p.prodRelId, pr.prodId,prd.prodId,p.relTpId, p.isActv) from ProdRel p inner join p.prod1 pr inner join p.prod2 prd ")
    Page<List<GetAllProdRelResponse>> getAllWithPagination(Pageable pageable);

}
