package com.etiya.crmlite.business.abstracts.common;

import com.etiya.crmlite.business.dtos.response.cam.party.GetAllPartyResponse;
import com.etiya.crmlite.business.dtos.response.common.etiyaTypeValue.GetAllEtiyaTypeValueResponse;
import com.etiya.crmlite.business.dtos.response.common.etiyaTypeValue.GetEtiyaTypeValueResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEtiyaTypeValueService {
    DataResult<List<GetAllEtiyaTypeValueResponse>> getAll();
    DataResult<Page<List<GetAllEtiyaTypeValueResponse>>> getAllWithPagination(Pageable pageable);
    DataResult<GetEtiyaTypeValueResponse> getById(Long id);
}
