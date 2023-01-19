package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetAllCustAcctProdInvlResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlFromACustResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustAcctProdInvlService {
    DataResult<List<GetAllCustAcctProdInvlResponse>> getAll();

    DataResult<Page<List<GetAllCustAcctProdInvlResponse>>> getAllWithPagination(Pageable pageable);

    DataResult<GetCustAcctProdInvlResponse> getById(Long id);

    DataResult<List<GetCustAcctProdInvlResponse>> getActvProdOfCust(Long custId);

    DataResult<List<GetCustAcctProdInvlFromACustResponse>>getActvProdOfBillAcct(Long custAcctId);
}
