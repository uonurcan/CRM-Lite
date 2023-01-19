package com.etiya.crmlite.repository.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodSpec.GetAllProdSpecResponse;
import com.etiya.crmlite.entities.concretes.product.ProdSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProdSpecRepository extends JpaRepository<ProdSpec,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.product.prodSpec.GetAllProdSpecResponse" +
            "(ps.prodSpecId, ps.name, ps.descr, ps.stId, ps.isDev) from ProdSpec ps")
    Page<List<GetAllProdSpecResponse>> getAllWithPagination(Pageable pageable);
}
