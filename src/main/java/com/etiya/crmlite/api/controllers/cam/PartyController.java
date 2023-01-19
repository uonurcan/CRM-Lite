package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.business.abstracts.cam.IPartyService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.cam.party.*;
import com.etiya.crmlite.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "PARTY")
@AllArgsConstructor
public class PartyController {
    private IPartyService iPartyService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllPartyResponse>> getAll() {
        return this.iPartyService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllPartyResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return this.iPartyService.getAllWithPagination(pageable);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetPartyResponse> getById(@RequestParam Long partyId) {
        return this.iPartyService.getById(partyId);
    }
}
