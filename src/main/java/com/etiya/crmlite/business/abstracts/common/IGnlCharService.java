package com.etiya.crmlite.business.abstracts.common;

import com.etiya.crmlite.business.dtos.response.common.etiyaTypeValue.GetAllEtiyaTypeValueResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetAllGnlCharResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetGnlCharResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGnlCharService {
    DataResult<List<GetAllGnlCharResponse>> getAll();
    DataResult<Page<List<GetAllGnlCharResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetGnlCharResponse> getById(Long id);
}
