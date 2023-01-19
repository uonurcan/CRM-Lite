package com.etiya.crmlite.business.concretes.order;

import com.etiya.crmlite.business.abstracts.order.ICustOrdService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.request.order.custOrd.SaveCustOrdRequest;
import com.etiya.crmlite.business.dtos.response.order.custOrd.GetAllCustOrdResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrd.GetCustOrdResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdCharVal.GetAllCustOrdCharValResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.core.utilities.results.SuccessResult;
import com.etiya.crmlite.entities.concretes.order.CustOrd;
import com.etiya.crmlite.repository.abstracts.order.ICustOrdRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustOrdManager implements ICustOrdService {
    private ICustOrdRepository iCustOrdRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllCustOrdResponse>> getAll() {
        List<CustOrd> custOrds = this.iCustOrdRepository.findAll();
        List<GetAllCustOrdResponse> response = custOrds.stream().map(custOrd -> iModelMapperService.forResponse().
                map(custOrd, GetAllCustOrdResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllCustOrdResponse>>(response,
                iMessageSourceService.getMessage(Messages.CustOrd.custOrdListed));
    }

    @Override
    public DataResult<GetCustOrdResponse> getById(Long custOrdId) {
        CustOrd custOrd= checkIfCustOrdExistsById(custOrdId);
        GetCustOrdResponse response = iModelMapperService
                .forResponse().map(custOrd, GetCustOrdResponse.class);
        return new SuccessDataResult<GetCustOrdResponse>(response,iMessageSourceService.getMessage(Messages.CustOrd.custOrdReceived));
    }

    @Override
    public Result save(SaveCustOrdRequest saveCustOrdRequest) {
        CustOrd customerOrder = CustOrd.builder()
                .bsnInterId(saveCustOrdRequest.getBsnInterId())
                .ordStId(saveCustOrdRequest.getOrdStId())
                .bsnInterSpecId(saveCustOrdRequest.getBsnInterSpecId())
                .custId(saveCustOrdRequest.getCustId())
                .build();
        iCustOrdRepository.save(customerOrder);
        return new SuccessResult();
    }

    private CustOrd checkIfCustOrdExistsById(Long custOrdId) {
        CustOrd currentCustOrd;
        try {
            currentCustOrd = iCustOrdRepository.findById( custOrdId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.CustOrd.custOrdNotExistWithId));
        }
        return currentCustOrd;
    }

    @Override
    public DataResult<Page<List<GetAllCustOrdResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllCustOrdResponse>> response =
                this.iCustOrdRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllCustOrdResponse>>>
                (response,iMessageSourceService.getMessage(Messages.CustOrd.custOrdListed));
    }
}
