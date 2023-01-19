package com.etiya.crmlite.api.controllers.common;

import com.etiya.crmlite.business.abstracts.common.IGnlCharService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.cam.addr.GetAllAddrResponse;
import com.etiya.crmlite.business.dtos.response.common.etiyaTypeValue.GetAllEtiyaTypeValueResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlChar.*;
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
@RequestMapping(Paths.apiPrefix + "GNL_CHAR")
@AllArgsConstructor
public class GnlCharController {
    private IGnlCharService iGnlCharService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllGnlCharResponse>> getAll(){ return this.iGnlCharService.getAll(); }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllGnlCharResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return this.iGnlCharService.getAllWithPagination(pageable);
    }
    @GetMapping("/get-by-id")
    public DataResult<GetGnlCharResponse> getById(@RequestParam Long gnlCharId) {return this.iGnlCharService.getById(gnlCharId);}
}

