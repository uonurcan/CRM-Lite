package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.business.abstracts.cam.IPartyRoleService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.cam.partyRole.*;
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
@RequestMapping(Paths.apiPrefix + "PARTY_ROLE")
@AllArgsConstructor
public class PartyRoleController {
    private IPartyRoleService iPartyRoleService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllPartyRoleResponse>> getAll() {
        return this.iPartyRoleService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllPartyRoleResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return this.iPartyRoleService.getAllWithPagination(pageable);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetPartyRoleResponse> getById(@RequestParam Long partyRoleId) {
        return this.iPartyRoleService.getById(partyRoleId);
    }
}