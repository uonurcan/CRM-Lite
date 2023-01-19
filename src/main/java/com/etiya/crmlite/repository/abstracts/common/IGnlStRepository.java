package com.etiya.crmlite.repository.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.gnlSt.GetAllGnlStResponse;
import com.etiya.crmlite.entities.concretes.common.GnlSt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGnlStRepository extends JpaRepository<GnlSt, Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.common.gnlSt.GetAllGnlStResponse" +
            "(gs.gnlStId, gs.name, gs.descr, gs.shrtCode, gs.isActv, gs.entCodeName, gs.entName)" +
            " from GnlSt gs ")
    Page<List<GetAllGnlStResponse>> getAllWithPagination(Pageable pageable);
}
