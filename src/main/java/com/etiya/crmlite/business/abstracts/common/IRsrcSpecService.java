package com.etiya.crmlite.business.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.gnlTp.GetAllGnlTpResponse;
import com.etiya.crmlite.business.dtos.response.common.rsrcSpec.GetAllRsrcSpecResponse;
import com.etiya.crmlite.business.dtos.response.common.rsrcSpec.GetRsrcSpecResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRsrcSpecService {
    DataResult<List<GetAllRsrcSpecResponse>> getAll();
    DataResult<Page<List<GetAllRsrcSpecResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetRsrcSpecResponse> getById(Long id);
}
