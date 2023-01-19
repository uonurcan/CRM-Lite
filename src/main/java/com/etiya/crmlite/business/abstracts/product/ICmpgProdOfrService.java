package com.etiya.crmlite.business.abstracts.product;

import com.etiya.crmlite.business.dtos.response.order.custOrd.GetAllCustOrdResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr.GetAllCmpgProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr.GetCmpgProdOfrResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICmpgProdOfrService {
    DataResult<List<GetAllCmpgProdOfrResponse>> getAll();
    DataResult<Page<List<GetAllCmpgProdOfrResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetCmpgProdOfrResponse> getById(Long id);

}
