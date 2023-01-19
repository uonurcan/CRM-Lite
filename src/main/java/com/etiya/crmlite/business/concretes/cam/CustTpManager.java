package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.ICustTpService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.cam.custTp.GetAllCustTpResponse;
import com.etiya.crmlite.business.dtos.response.cam.custTp.GetCustTpResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.cam.CustTp;
import com.etiya.crmlite.repository.abstracts.cam.ICustTpRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustTpManager implements ICustTpService {
    private ICustTpRepository iCustTpRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllCustTpResponse>> getAll() {
        List<CustTp> custTps = this.iCustTpRepository.findAll();
        List<GetAllCustTpResponse> response = custTps.stream().map(custTp -> iModelMapperService.forResponse().
                map(custTp, GetAllCustTpResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllCustTpResponse>>(response,
                iMessageSourceService.getMessage(Messages.CustTp.custTpListed));
    }

    @Override
    public DataResult<GetCustTpResponse> getById(Long custTpId) {
        CustTp custTp = checkIfCustTpExistsById(custTpId);
        GetCustTpResponse response = iModelMapperService
                .forResponse().map(custTp, GetCustTpResponse.class);
        return new SuccessDataResult<GetCustTpResponse>(response, iMessageSourceService.getMessage(Messages.CustTp.custTpReceived));
    }

    private CustTp checkIfCustTpExistsById(Long custTpId) {
        CustTp currentCustTp;
        try {
            currentCustTp = iCustTpRepository.findById(custTpId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.CustTp.custTpNotExistWithId));
        }
        return currentCustTp;
    }

    @Override
    public DataResult<Page<List<GetAllCustTpResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllCustTpResponse>> response =
                this.iCustTpRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllCustTpResponse>>>
                (response, iMessageSourceService.getMessage(Messages.CustTp.custTpListed));
    }

    @Override
    public CustTp getByIdRequest(Long custTpId) {
        return this.iCustTpRepository.findById(custTpId).orElseThrow();
    }
}
