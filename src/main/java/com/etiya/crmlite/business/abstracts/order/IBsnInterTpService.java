package com.etiya.crmlite.business.abstracts.order;

import com.etiya.crmlite.business.dtos.response.order.bsnInterSt.GetAllBsnInterStResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterTp.GetAllBsnInterTpResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterTp.GetBsnInterTpResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBsnInterTpService {
    DataResult<List<GetAllBsnInterTpResponse>> getAll();
    DataResult<Page<List<GetAllBsnInterTpResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetBsnInterTpResponse> getById(Long id);
}
