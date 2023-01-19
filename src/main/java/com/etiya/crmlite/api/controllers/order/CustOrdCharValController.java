package com.etiya.crmlite.api.controllers.order;

import com.etiya.crmlite.business.abstracts.order.ICustOrdCharValService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.order.bsnInterTp.GetAllBsnInterTpResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdCharVal.GetAllCustOrdCharValResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdCharVal.GetCustOrdCharValResponse;
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
@RequestMapping(Paths.apiPrefix + "CUST_ORD_CHAR_VAL")
@AllArgsConstructor
public class CustOrdCharValController {
   private ICustOrdCharValService iCustOrdCharValService;

   @GetMapping("/get-all")
   public DataResult<List<GetAllCustOrdCharValResponse>> getAll(){
      return this.iCustOrdCharValService.getAll();
   }

   @GetMapping("/get-all-with-pagination")
   public DataResult<Page<List<GetAllCustOrdCharValResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
      Pageable pageable = PageRequest.of(page-1,pageSize);
      return this.iCustOrdCharValService.getAllWithPagination(pageable);
   }
   @GetMapping("/get-by-id")
   public DataResult<GetCustOrdCharValResponse> getById(@RequestParam Long custOrdCharValId) {return this.iCustOrdCharValService.getById(custOrdCharValId);}
}
