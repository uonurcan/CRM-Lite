package com.etiya.crmlite.business.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.cmpg.GetAllCmpgResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpg.GetCmpgResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr.GetAllCmpgProdOfrResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICmpgService {
    DataResult<List<GetAllCmpgResponse>> getAll();
    DataResult<Page<List<GetAllCmpgResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetCmpgResponse> getById(Long id);
}
