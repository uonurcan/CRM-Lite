package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.IPartyService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.cam.party.GetAllPartyResponse;
import com.etiya.crmlite.business.dtos.response.cam.party.GetPartyResponse;
import com.etiya.crmlite.core.utilities.enums.GnlTps;
import com.etiya.crmlite.core.utilities.enums.StatusCode;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.cam.Ind;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import com.etiya.crmlite.repository.abstracts.cam.IPartyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PartyManager implements IPartyService {
    private IPartyRepository iPartyRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllPartyResponse>> getAll() {
        List<Party> parties = this.iPartyRepository.findAll();
        List<GetAllPartyResponse> response = parties.stream().map(party -> iModelMapperService.forResponse().
                map(party, GetAllPartyResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllPartyResponse>>(response,
                iMessageSourceService.getMessage(Messages.Party.partyListed));
    }

    @Override
    public DataResult<GetPartyResponse> getById(Long partyId) {
        Party party = checkIfPartyExistsById(partyId);
        GetPartyResponse response = iModelMapperService
                .forResponse().map(party, GetPartyResponse.class);
        return new SuccessDataResult<GetPartyResponse>(response, iMessageSourceService.getMessage(Messages.Party.partyReceived));
    }

    private Party checkIfPartyExistsById(Long partyId) {
        Party currentParty;
        try {
            currentParty = iPartyRepository.findById(partyId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.Party.partyNotExistWithId));
        }
        return currentParty;
    }

    @Override
    public DataResult<Page<List<GetAllPartyResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllPartyResponse>> response =
                this.iPartyRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllPartyResponse>>>
                (response, iMessageSourceService.getMessage(Messages.Party.partyListed));
    }

    @Override
    public Party createParty(Ind createInd, PartyRole createPartyRole) {

        return Party.builder()
                .stId(StatusCode.PARTY_ACTV)
                .partyTpId(GnlTps.INDV)
                .ind(createInd)
                .partyRoleList(List.of(createPartyRole))
                .build();
    }

    @Override
    public Party save(Party party) {
        return iPartyRepository.save(party);
    }

    @Override
    public void addPartyFromInd(Party party) {
        this.iPartyRepository.save(party);
    }
}
