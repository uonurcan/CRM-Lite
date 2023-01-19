package com.etiya.crmlite.api.controllers.common;

import com.etiya.crmlite.business.abstracts.common.IRsrcSpecService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.common.gnlTp.GetAllGnlTpResponse;
import com.etiya.crmlite.business.dtos.response.common.rsrcSpec.GetAllRsrcSpecResponse;
import com.etiya.crmlite.business.dtos.response.common.rsrcSpec.GetRsrcSpecResponse;
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
@RequestMapping(Paths.apiPrefix + "RSRC_SPEC")
@AllArgsConstructor
public class RsrcSpecController {
    private IRsrcSpecService iRsrcSpecService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllRsrcSpecResponse>> getAll(){
        return this.iRsrcSpecService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllRsrcSpecResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return this.iRsrcSpecService.getAllWithPagination(pageable);
    }
    @GetMapping("/get-by-id")
    public DataResult<GetRsrcSpecResponse> getById(@RequestParam Long rsrcSpecId) {return this.iRsrcSpecService.getById(rsrcSpecId);}
}
