package com.etiya.crmlite.business.concretes.product;

import com.etiya.crmlite.business.abstracts.product.ICmpgProdOfrService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.cam.addr.GetAllAddrResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpg.GetAllCmpgResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr.GetAllCmpgProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr.GetCmpgProdOfrResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.product.CmpgProdOfr;
import com.etiya.crmlite.repository.abstracts.product.ICmpgProdOfrRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CmpgProdOfrManager implements ICmpgProdOfrService {
    private ICmpgProdOfrRepository iCmpgProdOfrRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllCmpgProdOfrResponse>> getAll() {
        List<CmpgProdOfr> cmpgProdOfrs = this.iCmpgProdOfrRepository.findAll();
        List<GetAllCmpgProdOfrResponse> response = cmpgProdOfrs.stream().map(cmpgProdOfr -> iModelMapperService.forResponse().
                map(cmpgProdOfr, GetAllCmpgProdOfrResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllCmpgProdOfrResponse>>(response,
                iMessageSourceService.getMessage(Messages.CmpgProdOfr.cmpgProdOfrListed));
    }

    @Override
    public DataResult<GetCmpgProdOfrResponse> getById(Long cmpgProdOfrId) {
        CmpgProdOfr cmpgProdOfr= checkIfCmpgProdOfrExistsById(cmpgProdOfrId);
        GetCmpgProdOfrResponse response = iModelMapperService
                .forResponse().map(cmpgProdOfr, GetCmpgProdOfrResponse.class);
        return new SuccessDataResult<GetCmpgProdOfrResponse>(response,iMessageSourceService.getMessage(Messages.CmpgProdOfr.cmpgProdOfrReceived));
    }

    private CmpgProdOfr checkIfCmpgProdOfrExistsById(Long cmpgProdOfrId) {
        CmpgProdOfr currentCmpgProdOfr;
        try {
            currentCmpgProdOfr = iCmpgProdOfrRepository.findById(cmpgProdOfrId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.CmpgProdOfr.cmpgProdOfrNotExistWithId));
        }
        return currentCmpgProdOfr;
    }
    @Override
    public DataResult<Page<List<GetAllCmpgProdOfrResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllCmpgProdOfrResponse>> response =
                this.iCmpgProdOfrRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllCmpgProdOfrResponse>>>
                (response,iMessageSourceService.getMessage(Messages.CmpgProdOfr.cmpgProdOfrListed));
    }


}
