package com.etiya.crmlite.business.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.bsnInterTp.GetAllBsnInterTpResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdCharVal.GetAllCustOrdCharValResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdCharVal.GetCustOrdCharValResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustOrdCharValService {
    DataResult<List<GetAllCustOrdCharValResponse>> getAll();
    DataResult<Page<List<GetAllCustOrdCharValResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetCustOrdCharValResponse> getById(Long id);
}
