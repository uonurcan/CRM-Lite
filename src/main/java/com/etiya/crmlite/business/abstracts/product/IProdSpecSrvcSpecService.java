package com.etiya.crmlite.business.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodSpec.GetAllProdSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecSrvcSpec.GetAllProdSpecSrvcSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecSrvcSpec.GetProdSpecSrvcSpecResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProdSpecSrvcSpecService {
    DataResult<List<GetAllProdSpecSrvcSpecResponse>> getAll();
    DataResult<Page<List<GetAllProdSpecSrvcSpecResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetProdSpecSrvcSpecResponse> getById(Long id);
}
