package com.etiya.crmlite.repository.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.bsnInterSt.GetAllBsnInterStResponse;
import com.etiya.crmlite.entities.concretes.order.BsnInterSt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBsnInterStRepository extends JpaRepository<BsnInterSt,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.order.bsnInterSt." +
            "GetAllBsnInterStResponse(bis.bsnInterStId," +
            "bis.name, bis.descr, bis.shrtCode, bis.isActv) from BsnInterSt bis")
    Page<List<GetAllBsnInterStResponse>> getAllWithPagination(Pageable pageable);
}
