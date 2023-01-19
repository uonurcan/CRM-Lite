package com.etiya.crmlite.business.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodOfr.GetAllProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.prodRel.GetAllProdRelResponse;
import com.etiya.crmlite.business.dtos.response.product.prodRel.GetProdRelResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProdRelService {
    DataResult<List<GetAllProdRelResponse>> getAll();
    DataResult<Page<List<GetAllProdRelResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetProdRelResponse> getById(Long id);
}
