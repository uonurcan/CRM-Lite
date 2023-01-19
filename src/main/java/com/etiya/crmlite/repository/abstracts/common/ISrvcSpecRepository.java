package com.etiya.crmlite.repository.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.srvcSpec.GetAllSrvcSpecResponse;
import com.etiya.crmlite.entities.concretes.common.SrvcSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISrvcSpecRepository extends JpaRepository<SrvcSpec,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.common.srvcSpec.GetAllSrvcSpecResponse" +
            "(ss.srvcSpecId, ss.name, ss.descr, ss.srvcCode, ss.stId)" +
            " from SrvcSpec ss ")
    Page<List<GetAllSrvcSpecResponse>> getAllWithPagination(Pageable pageable);
}
