package com.etiya.crmlite.api.controllers.order;

import com.etiya.crmlite.business.abstracts.order.ICustOrdService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.order.custOrd.*;
import com.etiya.crmlite.business.dtos.response.order.custOrdCharVal.GetAllCustOrdCharValResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdItem.GetAllCustOrdItemResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdItem.GetCustOrdItemResponse;
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
@RequestMapping(Paths.apiPrefix + "CUST_ORD")
@AllArgsConstructor
public class CustOrdController {
   private ICustOrdService iCustOrdService;

   @GetMapping("/get-all")
   public DataResult<List<GetAllCustOrdResponse>> getAll(){
      return this.iCustOrdService.getAll();
   }

   @GetMapping("/get-all-with-pagination")
   public DataResult<Page<List<GetAllCustOrdResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
      Pageable pageable = PageRequest.of(page-1,pageSize);
      return this.iCustOrdService.getAllWithPagination(pageable);
   }
   @GetMapping("/get-by-id")
   public DataResult<GetCustOrdResponse> getById(@RequestParam Long custOrdId) {return this.iCustOrdService.getById(custOrdId);}
}
