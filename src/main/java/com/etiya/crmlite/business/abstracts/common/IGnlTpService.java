package com.etiya.crmlite.business.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.gnlSt.GetAllGnlStResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlTp.GetAllGnlTpResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlTp.GetGnlTpResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGnlTpService {
    DataResult<List<GetAllGnlTpResponse>> getAll();
    DataResult<Page<List<GetAllGnlTpResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetGnlTpResponse> getById(Long id);
}
