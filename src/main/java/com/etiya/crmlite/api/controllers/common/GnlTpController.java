package com.etiya.crmlite.api.controllers.common;

import com.etiya.crmlite.business.abstracts.common.IGnlTpService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.common.gnlSt.GetAllGnlStResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlTp.GetAllGnlTpResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlTp.GetGnlTpResponse;
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
@RequestMapping(Paths.apiPrefix + "GNL_TP")
@AllArgsConstructor
public class GnlTpController {
    private IGnlTpService iGnlTpService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllGnlTpResponse>> getAll(){
        return this.iGnlTpService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllGnlTpResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return this.iGnlTpService.getAllWithPagination(pageable);
    }
    @GetMapping("/get-by-id")
    public DataResult<GetGnlTpResponse> getById(@RequestParam Long gnlTpId) {return this.iGnlTpService.getById(gnlTpId);}
}
