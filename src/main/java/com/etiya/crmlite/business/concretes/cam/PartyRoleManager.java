package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.IPartyRoleService;
import com.etiya.crmlite.business.abstracts.cam.IPartyRoleTpService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.cam.partyRole.GetAllPartyRoleResponse;
import com.etiya.crmlite.business.dtos.response.cam.partyRole.GetPartyRoleResponse;
import com.etiya.crmlite.core.utilities.enums.PartyRoleTps;
import com.etiya.crmlite.core.utilities.enums.StatusCode;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import com.etiya.crmlite.repository.abstracts.cam.IPartyRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PartyRoleManager implements IPartyRoleService {
    private IPartyRoleRepository iPartyRoleRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;
    private IPartyRoleTpService iPartyRoleTpService;

    @Override
    public DataResult<List<GetAllPartyRoleResponse>> getAll() {
        List<PartyRole> partyRoles = this.iPartyRoleRepository.findAll();
        List<GetAllPartyRoleResponse> response = partyRoles.stream().map(partyRole -> iModelMapperService.forResponse().
                map(partyRole, GetAllPartyRoleResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllPartyRoleResponse>>(response,
                iMessageSourceService.getMessage(Messages.PartyRole.partyRoleListed));
    }

    @Override
    public DataResult<GetPartyRoleResponse> getById(Long partyRoleId) {
        PartyRole partyRole = checkIfPartyRoleExistsById(partyRoleId);
        GetPartyRoleResponse response = iModelMapperService
                .forResponse().map(partyRole, GetPartyRoleResponse.class);
        return new SuccessDataResult<GetPartyRoleResponse>(response, iMessageSourceService.getMessage(Messages.PartyRole.partyRoleReceived));
    }

    private PartyRole checkIfPartyRoleExistsById(Long partyRoleId) {
        PartyRole currentPartyRole;
        try {
            currentPartyRole = iPartyRoleRepository.findById(partyRoleId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.PartyRole.partyRoleNotExistWithId));
        }
        return currentPartyRole;
    }

    @Override
    public DataResult<Page<List<GetAllPartyRoleResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllPartyRoleResponse>> response =
                this.iPartyRoleRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllPartyRoleResponse>>>
                (response, iMessageSourceService.getMessage(Messages.PartyRole.partyRoleListed));
    }

    @Override
    public PartyRole createPartyRole(Cust cust) {
        return PartyRole.builder()
                .stId(StatusCode.PARTY_ROLE_ACTV)
                .custList(List.of(cust))
                .partyRoleTp(iPartyRoleTpService.getByIdRequest(PartyRoleTps.CUST2))
                .build();
    }

    @Override
    public void addPartyRoleFromInd(PartyRole partyRole) {
        this.iPartyRoleRepository.save(partyRole);
    }

}
