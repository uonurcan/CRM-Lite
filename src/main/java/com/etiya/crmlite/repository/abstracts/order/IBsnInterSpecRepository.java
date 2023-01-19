package com.etiya.crmlite.repository.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.bsnInterSpec.GetAllBsnInterSpecResponse;
import com.etiya.crmlite.entities.concretes.order.BsnInterSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBsnInterSpecRepository extends JpaRepository<BsnInterSpec,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.order.bsnInterSpec.GetAllBsnInterSpecResponse" +
            "(bis.bsnInterSpecId, bit.bsnInterTpId, bis.name, " +
            "bis.descr, bis.shrtCode, bis.isActv ) from BsnInterSpec bis join bis.bsnInterTp bit")
    Page<List<GetAllBsnInterSpecResponse>> getAllWithPagination(Pageable pageable);
}
