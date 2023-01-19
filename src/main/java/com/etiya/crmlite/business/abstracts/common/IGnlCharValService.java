package com.etiya.crmlite.business.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetAllGnlCharResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlCharVal.GetAllGnlCharValResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlCharVal.GetGnlCharValResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGnlCharValService {
    DataResult<List<GetAllGnlCharValResponse>> getAll();
    DataResult<Page<List<GetAllGnlCharValResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetGnlCharValResponse> getById(Long id);
}
