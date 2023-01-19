package com.etiya.crmlite.business.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.custOrdCharVal.GetAllCustOrdCharValResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdItem.GetAllCustOrdItemResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdItem.GetCustOrdItemResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustOrdItemService {
    DataResult<List<GetAllCustOrdItemResponse>> getAll();
    DataResult<Page<List<GetAllCustOrdItemResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetCustOrdItemResponse> getById(Long id);
}
