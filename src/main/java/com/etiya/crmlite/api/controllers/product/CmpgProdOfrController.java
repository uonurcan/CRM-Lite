package com.etiya.crmlite.api.controllers.product;

import com.etiya.crmlite.business.abstracts.product.ICmpgProdOfrService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.product.cmpg.GetAllCmpgResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr.GetAllCmpgProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr.GetCmpgProdOfrResponse;
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
@RequestMapping(Paths.apiPrefix + "CMPG_PROD_OFR")
@AllArgsConstructor
public class CmpgProdOfrController {
   private ICmpgProdOfrService iCmpgProdOfrService;

   @GetMapping("/get-all")
   public DataResult<List<GetAllCmpgProdOfrResponse>> getAll(){
      return this.iCmpgProdOfrService.getAll();
   }

   @GetMapping("/get-all-with-pagination")
   public DataResult<Page<List<GetAllCmpgProdOfrResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
      Pageable pageable = PageRequest.of(page-1,pageSize);
      return this.iCmpgProdOfrService.getAllWithPagination(pageable);
   }
   @GetMapping("/get-by-id")
   public DataResult<GetCmpgProdOfrResponse> getById(@RequestParam Long cmpgProdOfrId) {return this.iCmpgProdOfrService.getById(cmpgProdOfrId);}
}
