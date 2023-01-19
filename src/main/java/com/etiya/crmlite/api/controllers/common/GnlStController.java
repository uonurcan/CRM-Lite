package com.etiya.crmlite.api.controllers.common;

import com.etiya.crmlite.business.abstracts.common.IGnlStService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.common.gnlCharVal.GetAllGnlCharValResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlSt.GetAllGnlStResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlSt.GetGnlStResponse;
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
@RequestMapping(Paths.apiPrefix + "GNL_ST")
@AllArgsConstructor
public class GnlStController {
    private IGnlStService iGnlStService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllGnlStResponse>> getAll(){
        return this.iGnlStService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllGnlStResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return this.iGnlStService.getAllWithPagination(pageable);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetGnlStResponse> getById(@RequestParam Long gnlStId) {return this.iGnlStService.getById(gnlStId);}
}
