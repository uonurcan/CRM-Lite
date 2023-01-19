package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.business.abstracts.cam.IPartyRoleTpService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.cam.partyRoleTp.*;
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
@RequestMapping(Paths.apiPrefix + "PARTY_ROLE_TP")
@AllArgsConstructor
public class PartyRoleTpController {
    private IPartyRoleTpService iPartyRoleTpService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllPartyRoleTpResponse>> getAll() {
        return this.iPartyRoleTpService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllPartyRoleTpResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return this.iPartyRoleTpService.getAllWithPagination(pageable);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetPartyRoleTpResponse> getById(@RequestParam Long partyRoleTpId) {
        return this.iPartyRoleTpService.getById(partyRoleTpId);
    }
}
