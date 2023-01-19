package com.etiya.crmlite.business.concretes.common;

import com.etiya.crmlite.business.abstracts.common.IGnlCharValService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetAllGnlCharResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlCharVal.GetAllGnlCharValResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlCharVal.GetGnlCharValResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.common.GnlCharVal;
import com.etiya.crmlite.repository.abstracts.common.IGnlCharValRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GnlCharValManager implements IGnlCharValService {
    private IGnlCharValRepository iGnlCharValRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllGnlCharValResponse>> getAll() {
        List<GnlCharVal> gnlCharVals = this.iGnlCharValRepository.findAll();
        List<GetAllGnlCharValResponse> response = gnlCharVals.stream().map(gnlCharVal -> iModelMapperService.forResponse().
                map(gnlCharVal, GetAllGnlCharValResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllGnlCharValResponse>>(response,
                iMessageSourceService.getMessage(Messages.GnlCharVal.gnlCharValListed));
    }

    @Override
    public DataResult<GetGnlCharValResponse> getById(Long gnlCharValId) {
        GnlCharVal gnlCharVal= checkIfGnlCharExistsById(gnlCharValId);
        GetGnlCharValResponse response = iModelMapperService
                .forResponse().map(gnlCharVal, GetGnlCharValResponse.class);
        return new SuccessDataResult<GetGnlCharValResponse>(response,iMessageSourceService.getMessage(Messages.GnlCharVal.gnlCharValReceived));
    }

    private GnlCharVal checkIfGnlCharExistsById(Long gnlCharValId) {
        GnlCharVal currentGnlCharVal;
        try {
            currentGnlCharVal = iGnlCharValRepository.findById(gnlCharValId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.GnlCharVal.gnlCharValNotExistWithId));
        }
        return currentGnlCharVal;
    }

    @Override
    public DataResult<Page<List<GetAllGnlCharValResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllGnlCharValResponse>> response =
                this.iGnlCharValRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllGnlCharValResponse>>>
                (response,iMessageSourceService.getMessage(Messages.GnlCharVal.gnlCharValListed));
    }
}
