package com.etiya.crmlite.business.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodCharVal.GetAllProdCharValResponse;
import com.etiya.crmlite.business.dtos.response.product.prodOfr.GetAllProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.prodOfr.GetProdOfrResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProdOfrService {
    DataResult<List<GetAllProdOfrResponse>> getAll();
    DataResult<Page<List<GetAllProdOfrResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetProdOfrResponse> getById(Long id);
}
