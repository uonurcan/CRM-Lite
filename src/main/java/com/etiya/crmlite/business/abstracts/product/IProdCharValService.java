package com.etiya.crmlite.business.abstracts.product;

import com.etiya.crmlite.business.dtos.response.product.prodCatal.GetAllProdCatalResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCharVal.GetAllProdCharValResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCharVal.GetProdCharValResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProdCharValService {
    DataResult<List<GetAllProdCharValResponse>> getAll();
    DataResult<Page<List<GetAllProdCharValResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetProdCharValResponse> getById(Long id);
}
