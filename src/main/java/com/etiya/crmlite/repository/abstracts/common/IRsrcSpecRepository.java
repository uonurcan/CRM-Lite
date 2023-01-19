package com.etiya.crmlite.repository.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.rsrcSpec.GetAllRsrcSpecResponse;
import com.etiya.crmlite.entities.concretes.common.RsrcSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRsrcSpecRepository extends JpaRepository<RsrcSpec,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.common.rsrcSpec.GetAllRsrcSpecResponse" +
            "(rs.rsrcSpecId, rs.name, rs.descr, rs.stId, rs.rsrcCode)" +
            " from RsrcSpec rs ")
    Page<List<GetAllRsrcSpecResponse>> getAllWithPagination(Pageable pageable);
}
