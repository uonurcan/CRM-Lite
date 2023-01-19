package com.etiya.crmlite.repository.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.addr.GetAllAddrResponse;
import com.etiya.crmlite.entities.concretes.cam.Addr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAddrRepository extends JpaRepository<Addr, Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.cam.addr." +
            "GetAllAddrResponse(a.addrId,a.rowId,a.dataTpId,a.strtId,a.bldgId," +
            "a.addrDesc,a.isActv,a.cityName,a.strtName,a.bldgName,a.cntryName) from Addr a ")
    Page<List<GetAllAddrResponse>> getAllWithPagination(Pageable pageable);
}
