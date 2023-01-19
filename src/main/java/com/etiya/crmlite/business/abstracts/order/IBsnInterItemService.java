package com.etiya.crmlite.business.abstracts.order;

import com.etiya.crmlite.business.dtos.response.common.srvcSpec.GetAllSrvcSpecResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterItem.GetAllBsnInterItemResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterItem.GetBsnInterItemResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBsnInterItemService {
    DataResult<List<GetAllBsnInterItemResponse>> getAll();
    DataResult<Page<List<GetAllBsnInterItemResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetBsnInterItemResponse> getById(Long id);
}
