package com.etiya.crmlite.business.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prod.GetAllProdResponse;
import com.etiya.crmlite.business.dtos.response.product.prod.GetProdResponse;
import com.etiya.crmlite.business.dtos.response.product.prodRel.GetAllProdRelResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProdService {
    DataResult<List<GetAllProdResponse>> getAll();
    DataResult<Page<List<GetAllProdResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetProdResponse> getById(Long id);
}
