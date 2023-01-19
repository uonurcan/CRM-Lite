package com.etiya.crmlite.repository.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.ind.GetAllIndResponse;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.entities.concretes.cam.Ind;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IIndRepository extends JpaRepository<Ind,Long> {
    @Query("select new com.etiya.crmlite.business.dtos.response.cam.ind.GetAllIndResponse" +
            "(i.indId, p.partyId, i.frstName, i.mName, i.lstName, i.brthDate, i.gendrId, i.mthrName, i.fthrName, i.natId, i.stId)" +
            " from Ind i join i.party p")
    Page<List<GetAllIndResponse>> getAllWithPagination(Pageable pageable);

    Ind findByNatId(Long nationalityId);

    @Query("select c from Cust c join c.partyRole pr join pr.party p join p.ind i where i.indId =:id")
    Cust getByIndividualId(Long id);
}
