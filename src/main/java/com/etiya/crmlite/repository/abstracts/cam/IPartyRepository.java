package com.etiya.crmlite.repository.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.party.GetAllPartyResponse;
import com.etiya.crmlite.entities.concretes.cam.Party;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPartyRepository extends JpaRepository<Party,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.cam.party.GetAllPartyResponse" +
            "(pa.partyId, pa.partyTpId, pa.stId)" +
            " from Party pa ")
    Page<List<GetAllPartyResponse>> getAllWithPagination(Pageable pageable);
}
