package com.etiya.crmlite.repository.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.partyRole.GetAllPartyRoleResponse;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPartyRoleRepository extends JpaRepository<PartyRole, Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.cam.partyRole.GetAllPartyRoleResponse" +
            "(pa.partyRoleId, p.partyId, prt.partyRoleTpId, pa.stId)" +
            " from PartyRole pa join pa.party p join pa.partyRoleTp prt")
    Page<List<GetAllPartyRoleResponse>> getAllWithPagination(Pageable pageable);
}
