package com.etiya.crmlite.repository.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodSpecSrvcSpec.GetAllProdSpecSrvcSpecResponse;
import com.etiya.crmlite.entities.concretes.product.ProdSpecSrvcSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProdSpecSrvcSpecRepository extends JpaRepository<ProdSpecSrvcSpec, Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.product.prodSpecSrvcSpec.GetAllProdSpecSrvcSpecResponse" +
            "(psss.prodSpecSrvcSpecId, ps.prodSpecId, ss.srvcSpecId, psss.relTpId, psss.sDate, psss.eDate, psss.stId) " +
            "from ProdSpecSrvcSpec psss join psss.prodSpec ps join psss.srvcSpec ss")
    Page<List<GetAllProdSpecSrvcSpecResponse>> getAllWithPagination(Pageable pageable);
}
