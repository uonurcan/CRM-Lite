package com.etiya.crmlite.repository.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetAllGnlCharResponse;
import com.etiya.crmlite.entities.concretes.common.GnlChar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGnlCharRepository extends JpaRepository<GnlChar,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.common.gnlChar.GetAllGnlCharResponse" +
            "(gc.charId, gc.name, gc.descr, gc.prvdrCls, gc.shrtCode, gc.isActv)" +
            " from GnlChar gc ")
    Page<List<GetAllGnlCharResponse>> getAllWithPagination(Pageable pageable);

}
