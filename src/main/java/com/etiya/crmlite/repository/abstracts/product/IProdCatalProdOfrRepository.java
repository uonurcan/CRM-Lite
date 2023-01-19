package com.etiya.crmlite.repository.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr.GetAllProdCatalProdOfrResponse;
import com.etiya.crmlite.entities.concretes.product.ProdCatalProdOfr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProdCatalProdOfrRepository extends JpaRepository<ProdCatalProdOfr, Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr.GetAllProdCatalProdOfrResponse" +
            "(pcpo.prodCatalProdOfrId, pc.prodCatalId,po.prodOfrId, pcpo.stId  ) " +
            "from ProdCatalProdOfr pcpo join pcpo.prodOfr po join pcpo.prodCatal pc")
    Page<List<GetAllProdCatalProdOfrResponse>> getAllWithPagination(Pageable pageable);
}
