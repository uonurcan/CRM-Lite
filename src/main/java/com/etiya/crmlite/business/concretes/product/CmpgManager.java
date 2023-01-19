package com.etiya.crmlite.business.concretes.product;

import com.etiya.crmlite.business.abstracts.product.ICmpgService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.cam.addr.GetAllAddrResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpg.GetAllCmpgResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpg.GetCmpgResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.product.Cmpg;
import com.etiya.crmlite.repository.abstracts.product.ICmpgRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CmpgManager implements ICmpgService {
    private ICmpgRepository iCmpgRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllCmpgResponse>> getAll() {
        List<Cmpg> cmpgs = this.iCmpgRepository.findAll();
        List<GetAllCmpgResponse> response = cmpgs.stream().map(cmpg -> iModelMapperService.forResponse().
                map(cmpg, GetAllCmpgResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllCmpgResponse>>(response,
                iMessageSourceService.getMessage(Messages.Cmpg.cmpgListed));
    }

    @Override
    public DataResult<GetCmpgResponse> getById(Long cmpgId) {
        Cmpg cmpg= checkIfCmpgExistsById(cmpgId);
        GetCmpgResponse response = iModelMapperService
                .forResponse().map(cmpg, GetCmpgResponse.class);
        return new SuccessDataResult<GetCmpgResponse>(response,iMessageSourceService.getMessage(Messages.Cmpg.cmpgReceived));
    }

    private Cmpg checkIfCmpgExistsById(Long cmpgId) {
        Cmpg currentCmpg;
        try {
            currentCmpg = iCmpgRepository.findById(cmpgId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.Cmpg.cmpgNotExistWithId));
        }
        return currentCmpg;
    }

    @Override
    public DataResult<Page<List<GetAllCmpgResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllCmpgResponse>> response =
                this.iCmpgRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllCmpgResponse>>>
                (response,iMessageSourceService.getMessage(Messages.Cmpg.cmpgListed));
    }

}
