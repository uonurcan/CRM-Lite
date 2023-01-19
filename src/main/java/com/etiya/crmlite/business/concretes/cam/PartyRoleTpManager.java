package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.IPartyRoleTpService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.cam.partyRoleTp.GetAllPartyRoleTpResponse;
import com.etiya.crmlite.business.dtos.response.cam.partyRoleTp.GetPartyRoleTpResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.cam.PartyRoleTp;
import com.etiya.crmlite.repository.abstracts.cam.IPartyRoleTpRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PartyRoleTpManager implements IPartyRoleTpService {
    private IPartyRoleTpRepository iPartyRoleTpRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllPartyRoleTpResponse>> getAll() {
        List<PartyRoleTp> partyRoleTps = this.iPartyRoleTpRepository.findAll();
        List<GetAllPartyRoleTpResponse> response = partyRoleTps.stream().map(partyRoleTp -> iModelMapperService.forResponse().
                map(partyRoleTp, GetAllPartyRoleTpResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllPartyRoleTpResponse>>(response,
                iMessageSourceService.getMessage(Messages.PartyRoleTp.partyRoleTpListed));
    }

    @Override
    public DataResult<GetPartyRoleTpResponse> getById(Long partyRoleTpId) {
        PartyRoleTp partyRoleTp = checkIfPartyRoleTpExistsById(partyRoleTpId);
        GetPartyRoleTpResponse response = iModelMapperService
                .forResponse().map(partyRoleTp, GetPartyRoleTpResponse.class);
        return new SuccessDataResult<GetPartyRoleTpResponse>(response, iMessageSourceService.getMessage(Messages.PartyRoleTp.partyRoleTpReceived));
    }

    private PartyRoleTp checkIfPartyRoleTpExistsById(Long partyRoleTpId) {
        PartyRoleTp currentPartyRoleTp;
        try {
            currentPartyRoleTp = iPartyRoleTpRepository.findById(partyRoleTpId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.PartyRoleTp.partyRoleTpNotExistWithId));
        }
        return currentPartyRoleTp;
    }

    @Override
    public DataResult<Page<List<GetAllPartyRoleTpResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllPartyRoleTpResponse>> response =
                this.iPartyRoleTpRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllPartyRoleTpResponse>>>
                (response, iMessageSourceService.getMessage(Messages.PartyRoleTp.partyRoleTpListed));
    }

    @Override
    public PartyRoleTp getByIdRequest(Long partyRoleTpId) {
        return this.iPartyRoleTpRepository.findById(partyRoleTpId).orElseThrow();
    }
}
