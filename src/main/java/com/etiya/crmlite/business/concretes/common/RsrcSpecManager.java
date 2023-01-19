package com.etiya.crmlite.business.concretes.common;

import com.etiya.crmlite.business.abstracts.common.IRsrcSpecService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetAllGnlCharResponse;
import com.etiya.crmlite.business.dtos.response.common.rsrcSpec.GetAllRsrcSpecResponse;
import com.etiya.crmlite.business.dtos.response.common.rsrcSpec.GetRsrcSpecResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.common.RsrcSpec;
import com.etiya.crmlite.repository.abstracts.common.IRsrcSpecRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RsrcSpecManager implements IRsrcSpecService {
    private IRsrcSpecRepository iRsrcSpecRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllRsrcSpecResponse>> getAll() {
        List<RsrcSpec> rsrcSpecs = this.iRsrcSpecRepository.findAll();
        List<GetAllRsrcSpecResponse> response = rsrcSpecs.stream().map(rsrcSpec -> iModelMapperService.forResponse().
                map(rsrcSpec, GetAllRsrcSpecResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllRsrcSpecResponse>>(response,
                iMessageSourceService.getMessage(Messages.RsrcSpec.rsrcSpecListed));
    }

    @Override
    public DataResult<GetRsrcSpecResponse> getById(Long rsrcSpecId) {
        RsrcSpec rsrcSpec= checkIfRsrcSpecById(rsrcSpecId);
        GetRsrcSpecResponse response = iModelMapperService
                .forResponse().map(rsrcSpec, GetRsrcSpecResponse.class);
        return new SuccessDataResult<GetRsrcSpecResponse>(response,iMessageSourceService.getMessage(Messages.RsrcSpec.rsrcSpecReceived));
    }

    private RsrcSpec checkIfRsrcSpecById(Long rsrcSpecId) {
        RsrcSpec currentRsrcSpec;
        try {
            currentRsrcSpec = iRsrcSpecRepository.findById(rsrcSpecId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.RsrcSpec.rsrcSpecNotExistWithId));
        }
        return currentRsrcSpec;
    }

    @Override
    public DataResult<Page<List<GetAllRsrcSpecResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllRsrcSpecResponse>> response =
                this.iRsrcSpecRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllRsrcSpecResponse>>>
                (response,iMessageSourceService.getMessage(Messages.RsrcSpec.rsrcSpecListed));
    }
}
