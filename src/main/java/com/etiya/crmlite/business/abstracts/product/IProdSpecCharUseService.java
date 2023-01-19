package com.etiya.crmlite.business.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prod.GetAllProdResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecCharUse.GetAllProdSpecCharUseResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecCharUse.GetProdSpecCharUseResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProdSpecCharUseService {
    DataResult<List<GetAllProdSpecCharUseResponse>> getAll();
    DataResult<Page<List<GetAllProdSpecCharUseResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetProdSpecCharUseResponse> getById(Long id);
}
