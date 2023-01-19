package com.etiya.crmlite.repository.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.partyRoleTp.GetAllPartyRoleTpResponse;
import com.etiya.crmlite.entities.concretes.cam.PartyRoleTp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPartyRoleTpRepository extends JpaRepository<PartyRoleTp,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.cam.partyRoleTp.GetAllPartyRoleTpResponse" +
            "(prt.partyRoleTpId, prt.name, prt.descr, prt.shrtCode, prt.isActv)" +
            " from PartyRoleTp prt")
    Page<List<GetAllPartyRoleTpResponse>> getAllWithPagination(Pageable pageable);
}
