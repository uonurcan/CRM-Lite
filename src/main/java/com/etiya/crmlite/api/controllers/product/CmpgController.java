package com.etiya.crmlite.api.controllers.product;

import com.etiya.crmlite.business.abstracts.product.ICmpgService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.order.custOrdItem.GetAllCustOrdItemResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpg.GetAllCmpgResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpg.GetCmpgResponse;
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
@RequestMapping(Paths.apiPrefix + "CMPG")
@AllArgsConstructor
public class CmpgController {
   private ICmpgService iCmpgService;

   @GetMapping("/get-all")
   public DataResult<List<GetAllCmpgResponse>> getAll(){
      return this.iCmpgService.getAll();
   }

   @GetMapping("/get-all-with-pagination")
   public DataResult<Page<List<GetAllCmpgResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
      Pageable pageable = PageRequest.of(page-1,pageSize);
      return this.iCmpgService.getAllWithPagination(pageable);
   }

   @GetMapping("/get-by-id")
   public DataResult<GetCmpgResponse> getById(@RequestParam Long cmpgId) {return this.iCmpgService.getById(cmpgId);}
}
