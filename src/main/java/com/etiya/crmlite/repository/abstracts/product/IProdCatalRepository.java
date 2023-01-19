package com.etiya.crmlite.repository.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodCatal.GetAllProdCatalResponse;
import com.etiya.crmlite.entities.concretes.product.ProdCatal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProdCatalRepository extends JpaRepository<ProdCatal,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.product.prodCatal.GetAllProdCatalResponse" +
            "(pc.prodCatalId, pc.name, pc.descr, pc.stId, pc.shrtCode) from ProdCatal pc")
    Page<List<GetAllProdCatalResponse>> getAllWithPagination(Pageable pageable);
}
