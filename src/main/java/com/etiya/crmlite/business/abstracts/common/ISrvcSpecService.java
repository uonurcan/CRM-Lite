package com.etiya.crmlite.business.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.rsrcSpec.GetAllRsrcSpecResponse;
import com.etiya.crmlite.business.dtos.response.common.srvcSpec.GetAllSrvcSpecResponse;
import com.etiya.crmlite.business.dtos.response.common.srvcSpec.GetSrvcSpecResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISrvcSpecService {
    DataResult<List<GetAllSrvcSpecResponse>> getAll();
    DataResult<Page<List<GetAllSrvcSpecResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetSrvcSpecResponse> getById(Long id);
}
