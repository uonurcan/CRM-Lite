package com.etiya.crmlite.repository.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodCharVal.GetAllProdCharValResponse;
import com.etiya.crmlite.entities.concretes.product.ProdCharVal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProdCharValRepository extends JpaRepository<ProdCharVal,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.product.prodCharVal.GetAllProdCharValResponse" +
            "(pcv.prodCharValId,pr.prodId,gc.charId,gcv.charValId,pcv.val,pcv.stId) " +
            "from ProdCharVal pcv join pcv.gnlChar gc join pcv.prod pr join pcv.gnlCharVal gcv")
    Page<List<GetAllProdCharValResponse>> getAllWithPagination(Pageable pageable);
}
