package com.etiya.crmlite.repository.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.cmpg.GetAllCmpgResponse;
import com.etiya.crmlite.entities.concretes.product.Cmpg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICmpgRepository extends JpaRepository<Cmpg,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.product.cmpg.GetAllCmpgResponse" +
            "(c.cmpgId, c.name, c.descr, c.cmpgCode, c.actvtEdate, c.stId, c.isPenalty) from Cmpg c ")
    Page<List<GetAllCmpgResponse>> getAllWithPagination(Pageable pageable);
}
