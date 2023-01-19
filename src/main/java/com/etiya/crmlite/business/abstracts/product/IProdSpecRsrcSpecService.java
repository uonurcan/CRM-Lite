package com.etiya.crmlite.business.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodSpecCharUse.GetAllProdSpecCharUseResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecRsrcSpec.GetAllProdSpecRsrcSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecRsrcSpec.GetProdSpecRsrcSpecResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProdSpecRsrcSpecService {
    DataResult<List<GetAllProdSpecRsrcSpecResponse>> getAll();
    DataResult<Page<List<GetAllProdSpecRsrcSpecResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetProdSpecRsrcSpecResponse> getById(Long id);
}
