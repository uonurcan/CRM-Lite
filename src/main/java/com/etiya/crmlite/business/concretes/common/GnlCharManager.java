package com.etiya.crmlite.business.concretes.common;

import com.etiya.crmlite.business.abstracts.common.IGnlCharService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.cam.partyRole.GetAllPartyRoleResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetAllGnlCharResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetGnlCharResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.common.GnlChar;
import com.etiya.crmlite.repository.abstracts.common.IGnlCharRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GnlCharManager implements IGnlCharService {
    private IGnlCharRepository iGnlCharRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllGnlCharResponse>> getAll() {
        List<GnlChar> gnlChars = this.iGnlCharRepository.findAll();
        List<GetAllGnlCharResponse> response = gnlChars.stream().map(gnlChar -> iModelMapperService.forResponse().
                map(gnlChar, GetAllGnlCharResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllGnlCharResponse>>(response,
                iMessageSourceService.getMessage(Messages.GnlChar.gnlCharListed));
    }

    @Override
    public DataResult<GetGnlCharResponse> getById(Long gnlCharId) {
        GnlChar gnlChar= checkIfGnlCharExistsById(gnlCharId);
        GetGnlCharResponse response = iModelMapperService
                .forResponse().map(gnlChar, GetGnlCharResponse.class);
        return new SuccessDataResult<GetGnlCharResponse>(response,iMessageSourceService.getMessage(Messages.GnlChar.gnlCharReceived));
    }

    private GnlChar checkIfGnlCharExistsById(Long gnlCharId) {
        GnlChar currentGnlChar;
        try {
            currentGnlChar = iGnlCharRepository.findById(gnlCharId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.GnlChar.gnlCharNotExistWithId));
        }
        return currentGnlChar;
    }

    @Override
    public DataResult<Page<List<GetAllGnlCharResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllGnlCharResponse>> response =
                this.iGnlCharRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllGnlCharResponse>>>
                (response,iMessageSourceService.getMessage(Messages.GnlChar.gnlCharListed));
    }
}
