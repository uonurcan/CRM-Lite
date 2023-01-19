package com.etiya.crmlite.business.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.cmpg.GetAllCmpgResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr.GetAllProdCatalProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr.GetProdCatalProdOfrResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProdCatalProdOfrService {
    DataResult<List<GetAllProdCatalProdOfrResponse>> getAll();
    DataResult<Page<List<GetAllProdCatalProdOfrResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetProdCatalProdOfrResponse> getById(Long id);
}
