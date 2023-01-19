package com.etiya.crmlite.business.concretes.common;

import com.etiya.crmlite.business.abstracts.common.IGnlStService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetAllGnlCharResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlSt.GetAllGnlStResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlSt.GetGnlStResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.common.GnlSt;
import com.etiya.crmlite.repository.abstracts.common.IGnlStRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GnlStManager implements IGnlStService {
    private IGnlStRepository iGnlStRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllGnlStResponse>> getAll() {
        List<GnlSt> gnlSts = this.iGnlStRepository.findAll();
        List<GetAllGnlStResponse> response = gnlSts.stream().map(gnlSt -> iModelMapperService.forResponse().
                map(gnlSt, GetAllGnlStResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllGnlStResponse>>(response,
                iMessageSourceService.getMessage(Messages.GnlSt.gnlStListed));
    }

    @Override
    public DataResult<GetGnlStResponse> getById(Long gnlCharValId) {
        GnlSt gnlSt= checkIfGnlStById(gnlCharValId);
        GetGnlStResponse response = iModelMapperService
                .forResponse().map(gnlSt, GetGnlStResponse.class);
        return new SuccessDataResult<GetGnlStResponse>(response,iMessageSourceService.getMessage(Messages.GnlSt.gnlStReceived));
    }

    private GnlSt checkIfGnlStById(Long gnlStId) {
        GnlSt currentGnlSt;
        try {
            currentGnlSt = iGnlStRepository.findById(gnlStId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.GnlSt.gnlStNotExistWithId));
        }
        return currentGnlSt;
    }

    @Override
    public DataResult<Page<List<GetAllGnlStResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllGnlStResponse>> response =
                this.iGnlStRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllGnlStResponse>>>
                (response,iMessageSourceService.getMessage(Messages.GnlSt.gnlStListed));
    }
}
