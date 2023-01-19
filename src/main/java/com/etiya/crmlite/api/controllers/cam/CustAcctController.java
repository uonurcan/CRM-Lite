package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.business.abstracts.cam.ICustAcctService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.request.cam.custAcct.CreateCustAcctRequest;
import com.etiya.crmlite.business.dtos.request.cam.custAcct.DeleteCustAcctRequest;
import com.etiya.crmlite.business.dtos.request.cam.custAcct.UpdateCustAcctRequest;
import com.etiya.crmlite.business.dtos.response.cam.custAcct.GetAllCustAcctResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcct.GetCustAcctResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "CUST_ACCT")
@AllArgsConstructor
public class CustAcctController {
    private ICustAcctService iCustAcctService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllCustAcctResponse>> getAll() {
        return this.iCustAcctService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllCustAcctResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return this.iCustAcctService.getAllWithPagination(pageable);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetCustAcctResponse> getById(@RequestParam Long custAcctId) {
        return this.iCustAcctService.getById(custAcctId);
    }

    @RequestMapping(value = "/create-cust-acct", method = RequestMethod.POST)
    public Result add(@RequestBody @Valid CreateCustAcctRequest createCustAcctRequest) {
        return this.iCustAcctService.add(createCustAcctRequest);
    }

    @RequestMapping(value = "/update-cust-acct", method = RequestMethod.PUT)
    public Result update(@RequestBody @Valid UpdateCustAcctRequest updateCustAcctRequest) {
        return this.iCustAcctService.update(updateCustAcctRequest);
    }

    @RequestMapping(value = "/delete-cust-acct", method = RequestMethod.PUT)
    public Result delete(@RequestBody @Valid DeleteCustAcctRequest deleteCustAcctRequest) {
        return this.iCustAcctService.delete(deleteCustAcctRequest);
    }
}

