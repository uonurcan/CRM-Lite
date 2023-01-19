package com.etiya.crmlite.repository.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.custTp.GetAllCustTpResponse;
import com.etiya.crmlite.entities.concretes.cam.CustTp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustTpRepository extends JpaRepository<CustTp,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.cam.custTp.GetAllCustTpResponse" +
            "(ct.custTpId, ct.name, ct.descr, ct.partyTpId, ct.shrtCode, ct.isActv)" +
            " from CustTp ct ")
    Page<List<GetAllCustTpResponse>> getAllWithPagination(Pageable pageable);
}
