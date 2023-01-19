package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.request.cam.cust.CreateCustRequest;
import com.etiya.crmlite.business.dtos.request.cam.cust.DeleteCustRequest;
import com.etiya.crmlite.business.dtos.response.cam.cust.GetAllCustResponse;
import com.etiya.crmlite.business.dtos.response.cam.cust.GetCustResponse;
import com.etiya.crmlite.business.dtos.response.cam.cust.SearchCustResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustService {
    DataResult<List<GetAllCustResponse>> getAll();

    DataResult<GetCustResponse> getById(Long id);


    DataResult<Page<List<GetAllCustResponse>>> getAllWithPagination(Pageable pageable);

    DataResult<List<SearchCustResponse>> searchCust(Long nationalityId, Long customerId, String accountNumber,
                                                    String gsmNumber, String firstName, String lastName,
                                                    Long orderNumber);

    Result add(CreateCustRequest createCustRequest);

    void save(Cust cust);

    Result delete(DeleteCustRequest deleteCustRequest);

    void addNewCustFromInd(Cust cust);

    Cust getCustById(Long id);

}
