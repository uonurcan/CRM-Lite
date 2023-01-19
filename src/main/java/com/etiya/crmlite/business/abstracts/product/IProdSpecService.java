package com.etiya.crmlite.business.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodSpec.GetAllProdSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpec.GetProdSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecRsrcSpec.GetAllProdSpecRsrcSpecResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProdSpecService {
    DataResult<List<GetAllProdSpecResponse>> getAll();
    DataResult<Page<List<GetAllProdSpecResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetProdSpecResponse> getById(Long id);
}
