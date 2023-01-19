package com.etiya.crmlite.repository.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.gnlTp.GetAllGnlTpResponse;
import com.etiya.crmlite.entities.concretes.common.GnlTp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGnlTpRepository extends JpaRepository<GnlTp,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.common.gnlTp.GetAllGnlTpResponse" +
            "(gt.gnlTpId, gt.name, gt.descr, gt.shrtCode, gt.entCodeName, gt.entName, gt.isActv)" +
            " from GnlTp gt ")
    Page<List<GetAllGnlTpResponse>> getAllWithPagination(Pageable pageable);

}
