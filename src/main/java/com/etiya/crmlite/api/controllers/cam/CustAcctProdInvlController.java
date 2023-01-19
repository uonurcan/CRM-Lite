package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.business.abstracts.cam.ICustAcctProdInvlService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetAllCustAcctProdInvlResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlFromACustResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlResponse;
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
@RequestMapping(Paths.apiPrefix + "CUST_ACCT_PROD_INVL")
@AllArgsConstructor
public class CustAcctProdInvlController {
    private ICustAcctProdInvlService iCustAcctProdInvlService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllCustAcctProdInvlResponse>> getAll() {
        return this.iCustAcctProdInvlService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllCustAcctProdInvlResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return this.iCustAcctProdInvlService.getAllWithPagination(pageable);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetCustAcctProdInvlResponse> getById(@RequestParam Long custAcctProdInvlId) {
        return this.iCustAcctProdInvlService.getById(custAcctProdInvlId);
    }
    @GetMapping("/get-actv-prod-of-cust-acct")
    public DataResult<List<GetCustAcctProdInvlFromACustResponse>> getActvProdOfCustAcct(@RequestParam Long custAcctId){
        return this.iCustAcctProdInvlService.getActvProdOfBillAcct(custAcctId);
    }
}
