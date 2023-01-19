package com.etiya.crmlite.api.controllers.common;

import com.etiya.crmlite.business.abstracts.common.ISrvcSpecService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.common.rsrcSpec.GetAllRsrcSpecResponse;
import com.etiya.crmlite.business.dtos.response.common.srvcSpec.GetAllSrvcSpecResponse;
import com.etiya.crmlite.business.dtos.response.common.srvcSpec.GetSrvcSpecResponse;
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
@RequestMapping(Paths.apiPrefix + "SRVC_SPEC")
@AllArgsConstructor
public class SrvcSpecController {
    private ISrvcSpecService iSrvcSpecService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllSrvcSpecResponse>> getAll(){
        return this.iSrvcSpecService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllSrvcSpecResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return this.iSrvcSpecService.getAllWithPagination(pageable);
    }
    @GetMapping("/get-by-id")
    public DataResult<GetSrvcSpecResponse> getById(@RequestParam Long srvcSpecId) {return this.iSrvcSpecService.getById(srvcSpecId);}
}
