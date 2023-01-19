package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.partyRole.GetAllPartyRoleResponse;
import com.etiya.crmlite.business.dtos.response.cam.partyRole.GetPartyRoleResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPartyRoleService {
    DataResult<List<GetAllPartyRoleResponse>> getAll();

    DataResult<Page<List<GetAllPartyRoleResponse>>> getAllWithPagination(Pageable pageable);

    DataResult<GetPartyRoleResponse> getById(Long id);

    PartyRole createPartyRole(Cust cust);

    void addPartyRoleFromInd(PartyRole partyRole);
}
