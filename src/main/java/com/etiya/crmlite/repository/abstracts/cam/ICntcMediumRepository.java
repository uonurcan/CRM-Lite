package com.etiya.crmlite.repository.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.cntcMedium.GetAllCntcMediumResponse;
import com.etiya.crmlite.entities.concretes.cam.CntcMedium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICntcMediumRepository extends JpaRepository<CntcMedium,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.cam.cntcMedium.GetAllCntcMediumResponse" +
            "(cm.cntcMediumId,cm.rowId,cm.dataTpId,cm.cntcData,cm.stId,cm.cntcMediumTpId) " +
            "from CntcMedium cm")
    Page<List<GetAllCntcMediumResponse>> getAllWithPagination(Pageable pageable);
}
