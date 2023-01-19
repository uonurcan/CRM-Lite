package com.etiya.crmlite.repository.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prod.GetAllProdResponse;
import com.etiya.crmlite.entities.concretes.product.Prod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProdRepository extends JpaRepository<Prod,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.product.prod.GetAllProdResponse" +
            "(p.prodId, po.prodOfrId, ps.prodSpecId, p.name, p.descr,p.trnscId, p.cmpgId, p.stId) " +
            "from Prod p join p.prodSpec ps join p.prodOfr po")
    Page<List<GetAllProdResponse>> getAllWithPagination(Pageable pageable);
}
