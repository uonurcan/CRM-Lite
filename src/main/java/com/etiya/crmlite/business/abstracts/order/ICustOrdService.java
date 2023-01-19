package com.etiya.crmlite.business.abstracts.order;

import com.etiya.crmlite.business.dtos.request.order.custOrd.SaveCustOrdRequest;
import com.etiya.crmlite.business.dtos.response.order.custOrd.GetAllCustOrdResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrd.GetCustOrdResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdItem.GetAllCustOrdItemResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustOrdService {
    DataResult<List<GetAllCustOrdResponse>> getAll();
    DataResult<Page<List<GetAllCustOrdResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetCustOrdResponse> getById(Long id);
    Result save(SaveCustOrdRequest saveCustOrdRequest);

}
