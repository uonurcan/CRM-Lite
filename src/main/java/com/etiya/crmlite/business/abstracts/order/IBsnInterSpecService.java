package com.etiya.crmlite.business.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetAllBsnInterResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSpec.GetAllBsnInterSpecResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSpec.GetBsnInterSpecResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBsnInterSpecService {
    DataResult<List<GetAllBsnInterSpecResponse>> getAll();
    DataResult<Page<List<GetAllBsnInterSpecResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetBsnInterSpecResponse> getById(Long id);
}
