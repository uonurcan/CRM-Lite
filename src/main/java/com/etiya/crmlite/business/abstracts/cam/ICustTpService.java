package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.custTp.GetAllCustTpResponse;
import com.etiya.crmlite.business.dtos.response.cam.custTp.GetCustTpResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.entities.concretes.cam.CustTp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustTpService {
    DataResult<List<GetAllCustTpResponse>> getAll();

    DataResult<Page<List<GetAllCustTpResponse>>> getAllWithPagination(Pageable pageable);

    DataResult<GetCustTpResponse> getById(Long id);

    CustTp getByIdRequest(Long custTpId);
}
