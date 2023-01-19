package com.etiya.crmlite.api.controllers.cam;


import com.etiya.crmlite.business.abstracts.cam.ICustTpService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.cam.custTp.*;
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
@RequestMapping(Paths.apiPrefix + "CUST_TP")
@AllArgsConstructor
public class CustTpController {
    private ICustTpService iCustTpService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllCustTpResponse>> getAll() {
        return this.iCustTpService.getAll();
    }

    @GetMapping("/get-al-with-pagination")
    public DataResult<Page<List<GetAllCustTpResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return this.iCustTpService.getAllWithPagination(pageable);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetCustTpResponse> getById(@RequestParam Long custTpId) {
        return this.iCustTpService.getById(custTpId);
    }
}
