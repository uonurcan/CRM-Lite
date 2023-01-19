package com.etiya.crmlite.business.concretes.order;

import com.etiya.crmlite.business.abstracts.order.ICustOrdCharValService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetAllBsnInterResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdCharVal.GetAllCustOrdCharValResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdCharVal.GetCustOrdCharValResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.order.CustOrdCharVal;
import com.etiya.crmlite.repository.abstracts.order.ICustOrdCharValRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustOrdCharValManager implements ICustOrdCharValService {
    private ICustOrdCharValRepository iCustOrdCharValRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllCustOrdCharValResponse>> getAll() {
        List<CustOrdCharVal> custOrdCharVals = this.iCustOrdCharValRepository.findAll();
        List<GetAllCustOrdCharValResponse> response = custOrdCharVals.stream().map(custOrdCharVal -> iModelMapperService.forResponse().
                map(custOrdCharVal, GetAllCustOrdCharValResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllCustOrdCharValResponse>>(response,
                iMessageSourceService.getMessage(Messages.CustOrdCharVal.custOrdCharValListed));
    }

    @Override
    public DataResult<GetCustOrdCharValResponse> getById(Long custOrdCharValId) {
        CustOrdCharVal custOrdCharVal= checkIfCustOrdCharValExistsById(custOrdCharValId);
        GetCustOrdCharValResponse response = iModelMapperService
                .forResponse().map(custOrdCharVal, GetCustOrdCharValResponse.class);
        return new SuccessDataResult<GetCustOrdCharValResponse>(response,iMessageSourceService.getMessage(Messages.CustOrdCharVal.custOrdCharValReceived));
    }

    private CustOrdCharVal checkIfCustOrdCharValExistsById(Long custOrdCharValId) {
        CustOrdCharVal currentCustOrdCharVal;
        try {
            currentCustOrdCharVal = iCustOrdCharValRepository.findById( custOrdCharValId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.CustOrdCharVal.custOrdCharValNotExistWithId));
        }
        return currentCustOrdCharVal;
    }

    @Override
    public DataResult<Page<List<GetAllCustOrdCharValResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllCustOrdCharValResponse>> response =
                this.iCustOrdCharValRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllCustOrdCharValResponse>>>
                (response,iMessageSourceService.getMessage(Messages.CustOrdCharVal.custOrdCharValListed));
    }
}
