package com.etiya.crmlite.repository.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.etiyaTypeValue.GetAllEtiyaTypeValueResponse;
import com.etiya.crmlite.entities.concretes.common.EtiyaTypeValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEtiyaTypeValueRepository extends JpaRepository<EtiyaTypeValue,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.common.etiyaTypeValue.GetAllEtiyaTypeValueResponse" +
            "(etv.typeValueId, etv.tableName, etv.description, etv.value, etv.usingModuleName)" +
            " from EtiyaTypeValue etv ")
    Page<List<GetAllEtiyaTypeValueResponse>> getAllWithPagination(Pageable pageable);
}
