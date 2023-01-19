package com.etiya.crmlite.business.concretes.common;

import com.etiya.crmlite.business.abstracts.common.ISrvcSpecService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetAllGnlCharResponse;
import com.etiya.crmlite.business.dtos.response.common.srvcSpec.GetAllSrvcSpecResponse;
import com.etiya.crmlite.business.dtos.response.common.srvcSpec.GetSrvcSpecResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.common.SrvcSpec;
import com.etiya.crmlite.repository.abstracts.common.ISrvcSpecRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SrvcSpecManager implements ISrvcSpecService {
    private ISrvcSpecRepository iSrvcSpecRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllSrvcSpecResponse>> getAll() {
        List<SrvcSpec> srvcSpecs = this.iSrvcSpecRepository.findAll();
        List<GetAllSrvcSpecResponse> response = srvcSpecs.stream().map(srvcSpec -> iModelMapperService.forResponse().
                map(srvcSpec, GetAllSrvcSpecResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllSrvcSpecResponse>>(response,
                iMessageSourceService.getMessage(Messages.SrvcSpec.srvcSpecListed));
    }

    @Override
    public DataResult<GetSrvcSpecResponse> getById(Long srvcSpecId) {
        SrvcSpec srvcSpec= checkIfSrvcSpecById(srvcSpecId);
        GetSrvcSpecResponse response = iModelMapperService
                .forResponse().map(srvcSpec, GetSrvcSpecResponse.class);
        return new SuccessDataResult<GetSrvcSpecResponse>(response,iMessageSourceService.getMessage(Messages.SrvcSpec.srvcSpecReceived));
    }

    private SrvcSpec checkIfSrvcSpecById(Long srvcSpecId) {
        SrvcSpec currentSrvcSpec;
        try {
            currentSrvcSpec = iSrvcSpecRepository.findById(srvcSpecId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.SrvcSpec.srvcSpecNotExistWithId));
        }
        return currentSrvcSpec;
    }

    @Override
    public DataResult<Page<List<GetAllSrvcSpecResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllSrvcSpecResponse>> response =
                this.iSrvcSpecRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllSrvcSpecResponse>>>
                (response,iMessageSourceService.getMessage(Messages.SrvcSpec.srvcSpecListed));
    }
}
