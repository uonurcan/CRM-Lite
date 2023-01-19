package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.request.cam.addr.CreateAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.addr.DeleteAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.addr.UpdateAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.ind.CreateAddrWhenCreateIndRequest;
import com.etiya.crmlite.business.dtos.response.cam.addr.GetAddrResponse;
import com.etiya.crmlite.business.dtos.response.cam.addr.GetAllAddrResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.entities.concretes.cam.Addr;
import com.etiya.crmlite.entities.concretes.cam.Party;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAddrService {
    DataResult<List<GetAllAddrResponse>> getAll();

    DataResult<Page<List<GetAllAddrResponse>>> getAllWithPagination(Pageable pageable);

    DataResult<GetAddrResponse> getById(Long id);

    Result addAddr(CreateAddrWhenCreateIndRequest createAddrWhenCreateCustRequest, Party party);

    Result addAddr(CreateAddrRequest createAddrRequest);

    void save(Addr addr);

    Result deleteAddr(DeleteAddrRequest deleteAddrRequest);

    DataResult<UpdateAddrRequest> updateAddr(UpdateAddrRequest updateAddrRequest);

    Result add(CreateAddrRequest createAddressRequest);

    Result addAddrForCustBillAcct(CreateAddrRequest createAddrRequest);

    Result updateAddrForCustBillAcct(UpdateAddrRequest updateAddressRequest);

}
