package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.request.cam.addr.DeleteAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.cntcMedium.CreateCntcMediumRequest;
import com.etiya.crmlite.business.dtos.request.cam.cntcMedium.DeleteCntcMediumRequest;
import com.etiya.crmlite.business.dtos.request.cam.cntcMedium.UpdateCntcMediumRequest;
import com.etiya.crmlite.business.dtos.response.cam.cntcMedium.GetAllCntcMediumResponse;
import com.etiya.crmlite.business.dtos.response.cam.cntcMedium.GetCntcMediumResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.entities.concretes.cam.CntcMedium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICntcMediumService {
    DataResult<List<GetAllCntcMediumResponse>> getAll();

    DataResult<Page<List<GetAllCntcMediumResponse>>> getAllWithPagination(Pageable pageable);

    DataResult<GetCntcMediumResponse> getById(Long id);

    Result add(CreateCntcMediumRequest createCntcMediumRequest);

    Result update(UpdateCntcMediumRequest updateCntcMediumRequest);

    Result delete(DeleteCntcMediumRequest deleteCntcMediumRequest);

    void addCntcMediumFromInd(CntcMedium cntcMedium);

}
