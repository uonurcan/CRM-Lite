package com.etiya.crmlite.repository.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.bsnInterItem.GetAllBsnInterItemResponse;
import com.etiya.crmlite.entities.concretes.order.BsnInterItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBsnInterItemRepository extends JpaRepository<BsnInterItem,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.order.bsnInterItem.GetAllBsnInterItemResponse" +
            "(bii.bsnInterItemId, bi.bsnInterId, bis.bsnInterSpecId, bii.descr, " +
            "bii.rowId, bii.dataTpId, bii.actnTpId, bii.stId  ) from BsnInterItem bii join bii.bsnInter bi join bii.bsnInterSpec bis")
    Page<List<GetAllBsnInterItemResponse>> getAllWithPagination(Pageable pageable);
}
