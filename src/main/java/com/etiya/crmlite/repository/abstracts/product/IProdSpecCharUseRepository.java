package com.etiya.crmlite.repository.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodSpecCharUse.GetAllProdSpecCharUseResponse;
import com.etiya.crmlite.entities.concretes.product.ProdSpecCharUse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProdSpecCharUseRepository extends JpaRepository<ProdSpecCharUse,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.product.prodSpecCharUse." +
            "GetAllProdSpecCharUseResponse(pscu.prodSpecCharUseId," +
            "ps.prodSpecId, gc.charId, pscu.name, pscu.descr, pscu.isActv) " +
            "from ProdSpecCharUse pscu join pscu.prodSpec ps join pscu.gnlChar gc")
    Page<List<GetAllProdSpecCharUseResponse>> getAllWithPagination(Pageable pageable);
}
