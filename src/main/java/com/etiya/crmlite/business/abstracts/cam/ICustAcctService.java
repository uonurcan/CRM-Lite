package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.request.cam.custAcct.CreateCustAcctRequest;
import com.etiya.crmlite.business.dtos.request.cam.custAcct.DeleteCustAcctRequest;
import com.etiya.crmlite.business.dtos.request.cam.custAcct.UpdateCustAcctRequest;
import com.etiya.crmlite.business.dtos.response.cam.custAcct.GetAllCustAcctResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcct.GetCustAcctResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.entities.concretes.cam.CustAcct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustAcctService {
    DataResult<List<GetAllCustAcctResponse>> getAll();

    DataResult<Page<List<GetAllCustAcctResponse>>> getAllWithPagination(Pageable pageable);

    DataResult<GetCustAcctResponse> getById(Long id);

    void addCustAcctFromInd(CustAcct custAcct);

    Result add(CreateCustAcctRequest createCustAcctRequest);

    Result update(UpdateCustAcctRequest updateCustAcctRequest);

    Result delete(DeleteCustAcctRequest deleteCustAcctRequest);
}
