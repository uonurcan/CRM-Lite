package com.etiya.crmlite.repository.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.bsnInterTp.GetAllBsnInterTpResponse;
import com.etiya.crmlite.entities.concretes.order.BsnInterTp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBsnInterTpRepository extends JpaRepository<BsnInterTp,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.order.bsnInterTp." +
            "GetAllBsnInterTpResponse(bit.bsnInterTpId, " +
            "bit.name, bit.descr, bit.shrtCode, bit.isActv) from BsnInterTp bit")
    Page<List<GetAllBsnInterTpResponse>> getAllWithPagination(Pageable pageable);
}
