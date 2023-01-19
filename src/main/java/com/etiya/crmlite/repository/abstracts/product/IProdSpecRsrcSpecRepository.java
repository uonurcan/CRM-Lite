package com.etiya.crmlite.repository.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodSpecRsrcSpec.GetAllProdSpecRsrcSpecResponse;
import com.etiya.crmlite.entities.concretes.product.ProdSpecRsrcSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProdSpecRsrcSpecRepository extends JpaRepository<ProdSpecRsrcSpec, Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.product.prodSpecRsrcSpec.GetAllProdSpecRsrcSpecResponse" +
            "(psrs.prodSpecRsrcSpecId," +
            "ps.prodSpecId, rs.rsrcSpecId, psrs.relTpId, psrs.sDate, psrs.eDate, psrs.stId) " +
            "from ProdSpecRsrcSpec psrs join psrs.prodSpec ps join psrs.rsrcSpec rs ")
    Page<List<GetAllProdSpecRsrcSpecResponse>> getAllWithPagination(Pageable pageable);
}
