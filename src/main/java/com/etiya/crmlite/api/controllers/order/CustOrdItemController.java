package com.etiya.crmlite.api.controllers.order;

import com.etiya.crmlite.business.abstracts.order.ICustOrdItemService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.order.custOrd.GetAllCustOrdResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdItem.*;
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
@RequestMapping(Paths.apiPrefix + "CUST_ORD_ITEM")
@AllArgsConstructor
public class CustOrdItemController {
    private ICustOrdItemService iCustOrdItemService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllCustOrdItemResponse>> getAll(){
        return this.iCustOrdItemService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllCustOrdItemResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return this.iCustOrdItemService.getAllWithPagination(pageable);
    }
    @GetMapping("/get-by-id")
    public DataResult<GetCustOrdItemResponse> getById(@RequestParam Long custOrdItemId) {return this.iCustOrdItemService.getById(custOrdItemId);}
}
