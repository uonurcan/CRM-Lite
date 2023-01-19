package com.etiya.crmlite.api.controllers.common;

import com.etiya.crmlite.business.abstracts.common.IEtiyaTypeValueService;
import com.etiya.crmlite.business.constants.Paths;

import com.etiya.crmlite.business.dtos.response.cam.addr.GetAllAddrResponse;
import com.etiya.crmlite.business.dtos.response.common.etiyaTypeValue.*;
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
@RequestMapping(Paths.apiPrefix + "ETIYA_TYPE_VALUE")
@AllArgsConstructor
public class EtiyaTypeValueController {
    private IEtiyaTypeValueService iEtiyaTypeValueService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllEtiyaTypeValueResponse>> getAll(){
        return this.iEtiyaTypeValueService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllEtiyaTypeValueResponse>>> getAllWithPagination(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return this.iEtiyaTypeValueService.getAllWithPagination(pageable);
    }
    @GetMapping("/get-by-id")
    public DataResult<GetEtiyaTypeValueResponse> getById(@RequestParam Long etiyaTypeValueId) {return this.iEtiyaTypeValueService.getById(etiyaTypeValueId);}
}

