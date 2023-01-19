package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.request.cam.ind.CreateIndRequest;
import com.etiya.crmlite.business.dtos.request.cam.ind.UpdateIndRequest;
import com.etiya.crmlite.business.dtos.response.cam.ind.GetAllIndResponse;
import com.etiya.crmlite.business.dtos.response.cam.ind.GetIndResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.entities.concretes.cam.Ind;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IIndService {
    DataResult<List<Ind>> getAll();

    DataResult<Page<List<GetAllIndResponse>>> getAllWithPagination(Pageable pageable);

    DataResult<GetIndResponse> getById(Long id);

    Result add(CreateIndRequest createIndRequest);

    void save(Ind ind);

    Result updateInd(UpdateIndRequest updateIndRequest);

    void deleteIndFromCust(Ind ind);

}
