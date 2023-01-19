package com.etiya.crmlite.business.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodCatal.GetAllProdCatalResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCatal.GetProdCatalResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr.GetAllProdCatalProdOfrResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProdCatalService {
    DataResult<List<GetAllProdCatalResponse>> getAll();
    DataResult<Page<List<GetAllProdCatalResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetProdCatalResponse> getById(Long id);
}
