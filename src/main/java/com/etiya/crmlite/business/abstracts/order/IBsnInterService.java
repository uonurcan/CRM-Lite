package com.etiya.crmlite.business.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetAllBsnInterResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetBsnInterResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBsnInterService {
    DataResult<List<GetAllBsnInterResponse>> getAll();

    DataResult<Page<List<GetAllBsnInterResponse>>> getAllWithPagination(Pageable pageable);

    DataResult<GetBsnInterResponse> getById(Long id);

    Result startNewSale(Long custId);
}
