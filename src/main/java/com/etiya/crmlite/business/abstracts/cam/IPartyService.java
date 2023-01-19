package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.party.GetAllPartyResponse;
import com.etiya.crmlite.business.dtos.response.cam.party.GetPartyResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.entities.concretes.cam.Ind;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPartyService {
    DataResult<List<GetAllPartyResponse>> getAll();

    DataResult<Page<List<GetAllPartyResponse>>> getAllWithPagination(Pageable pageable);

    DataResult<GetPartyResponse> getById(Long id);

    Party createParty(Ind createInd, PartyRole createPartyRole);

    Party save(Party party);

    void addPartyFromInd(Party party);
}
