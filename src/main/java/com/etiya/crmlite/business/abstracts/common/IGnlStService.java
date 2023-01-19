package com.etiya.crmlite.business.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.gnlCharVal.GetAllGnlCharValResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlSt.GetAllGnlStResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlSt.GetGnlStResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGnlStService {
    DataResult<List<GetAllGnlStResponse>> getAll();
    DataResult<Page<List<GetAllGnlStResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetGnlStResponse> getById(Long id);
}
