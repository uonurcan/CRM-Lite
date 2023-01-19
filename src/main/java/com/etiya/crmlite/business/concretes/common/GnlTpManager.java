package com.etiya.crmlite.business.concretes.common;

import com.etiya.crmlite.business.abstracts.common.IGnlTpService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetAllGnlCharResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlTp.GetAllGnlTpResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlTp.GetGnlTpResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.common.GnlTp;
import com.etiya.crmlite.repository.abstracts.common.IGnlTpRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GnlTpManager implements IGnlTpService {
    private IGnlTpRepository iGnlTpRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllGnlTpResponse>> getAll() {
        List<GnlTp> gnlTps = this.iGnlTpRepository.findAll();
        List<GetAllGnlTpResponse> response = gnlTps.stream().map(gnlTp -> iModelMapperService.forResponse().
                map(gnlTp, GetAllGnlTpResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllGnlTpResponse>>(response,
                iMessageSourceService.getMessage(Messages.GnlTp.gnlTpListed));
    }

    @Override
    public DataResult<GetGnlTpResponse> getById(Long gnlTpId) {
        GnlTp gnlTp= checkIfGnlTpById(gnlTpId);
        GetGnlTpResponse response = iModelMapperService
                .forResponse().map(gnlTp, GetGnlTpResponse.class);
        return new SuccessDataResult<GetGnlTpResponse>(response,iMessageSourceService.getMessage(Messages.GnlTp.gnlTpReceived));
    }

    private GnlTp checkIfGnlTpById(Long gnlTpId) {
        GnlTp currentGnlTp;
        try {
            currentGnlTp = iGnlTpRepository.findById(gnlTpId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.GnlTp.gnlTpNotExistWithId));
        }
        return currentGnlTp;
    }

    @Override
    public DataResult<Page<List<GetAllGnlTpResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllGnlTpResponse>> response =
                this.iGnlTpRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllGnlTpResponse>>>
                (response,iMessageSourceService.getMessage(Messages.GnlTp.gnlTpListed));
    }
}
