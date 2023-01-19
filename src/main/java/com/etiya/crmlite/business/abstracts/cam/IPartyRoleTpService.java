package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.partyRoleTp.GetAllPartyRoleTpResponse;
import com.etiya.crmlite.business.dtos.response.cam.partyRoleTp.GetPartyRoleTpResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.entities.concretes.cam.PartyRoleTp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPartyRoleTpService {
    DataResult<List<GetAllPartyRoleTpResponse>> getAll();

    DataResult<Page<List<GetAllPartyRoleTpResponse>>> getAllWithPagination(Pageable pageable);

    DataResult<GetPartyRoleTpResponse> getById(Long id);

    PartyRoleTp getByIdRequest(Long partyRoleTpId);

}
