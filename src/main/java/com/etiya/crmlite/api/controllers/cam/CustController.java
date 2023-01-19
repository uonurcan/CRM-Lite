package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.business.abstracts.cam.ICustService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.request.cam.cust.CreateCustRequest;
import com.etiya.crmlite.business.dtos.request.cam.cust.DeleteCustRequest;
import com.etiya.crmlite.business.dtos.response.cam.cust.*;
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
@RequestMapping(Paths.apiPrefix + "CUST")
@AllArgsConstructor
public class CustController {
    private ICustService iCustService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllCustResponse>> getAll() {
        return this.iCustService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllCustResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return this.iCustService.getAllWithPagination(pageable);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetCustResponse> getById(@RequestParam Long custId) {
        return this.iCustService.getById(custId);
    }

    @GetMapping("/search-cust")
    public DataResult<List<SearchCustResponse>> searchCust(@RequestParam(required = false) Long nationalityId,
                                                           @RequestParam(required = false) Long customerId,
                                                           @RequestParam(required = false) String accountNumber,
                                                           @RequestParam(required = false) String gsmNumber,
                                                           @RequestParam(required = false) String firstName,
                                                           @RequestParam(required = false) String lastName,
                                                           @RequestParam(required = false) Long orderNumber) {
        return iCustService.searchCust(nationalityId, customerId, accountNumber, gsmNumber, firstName, lastName,
                orderNumber);
    }

    @PostMapping("/create-cust")
    public Result create(@RequestBody @Valid CreateCustRequest createCustRequest) {
        return this.iCustService.add(createCustRequest);
    }

    @RequestMapping(value = "/delete-cust", method = RequestMethod.PUT)
    public Result delete(@RequestBody @Valid DeleteCustRequest deleteCustRequest) {
        return this.iCustService.delete(deleteCustRequest);
    }
}
