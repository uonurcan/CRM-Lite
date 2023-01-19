package com.etiya.crmlite.repository.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.gnlCharVal.GetAllGnlCharValResponse;
import com.etiya.crmlite.entities.concretes.common.GnlCharVal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGnlCharValRepository extends JpaRepository<GnlCharVal, Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.common.gnlCharVal.GetAllGnlCharValResponse" +
            "(gcv.charValId, gcv.charId, gcv.isDflt, gcv.val, gcv.shrtCode, gcv.sDate, gcv.eDate, gcv.isActv)" +
            " from GnlCharVal gcv ")
    Page<List<GetAllGnlCharValResponse>> getAllWithPagination(Pageable pageable);
}
