package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.business.abstracts.cam.IIndService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.request.cam.ind.CreateIndRequest;
import com.etiya.crmlite.business.dtos.request.cam.ind.UpdateIndRequest;
import com.etiya.crmlite.business.dtos.response.cam.ind.*;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.entities.concretes.cam.Ind;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "IND")
@AllArgsConstructor
public class IndController {
    private IIndService iIndService;

    @GetMapping("/get-all")
    public DataResult<List<Ind>> getAll() {
        return this.iIndService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllIndResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return this.iIndService.getAllWithPagination(pageable);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetIndResponse> getById(@RequestParam Long indId) {
        return this.iIndService.getById(indId);
    }

    @PostMapping("/create-ind")
    public ResponseEntity<?> create(@RequestBody @Valid CreateIndRequest createIndRequest) {
        var response = iIndService.add(createIndRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update-ind")
    public Result update(@RequestBody @Valid UpdateIndRequest updateIndRequest) {
        return this.iIndService.updateInd(updateIndRequest);
    }
}

