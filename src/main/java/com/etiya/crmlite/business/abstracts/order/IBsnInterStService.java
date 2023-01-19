package com.etiya.crmlite.business.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.bsnInterSpec.GetAllBsnInterSpecResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSt.GetAllBsnInterStResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSt.GetBsnInterStResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBsnInterStService {
    DataResult<List<GetAllBsnInterStResponse>> getAll();
    DataResult<Page<List<GetAllBsnInterStResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetBsnInterStResponse> getById(Long id);
}
