package com.etiya.crmlite.api.controllers.product;

import com.etiya.crmlite.business.abstracts.product.IProdSpecSrvcSpecService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.product.prodSpecRsrcSpec.GetAllProdSpecRsrcSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecSrvcSpec.GetAllProdSpecSrvcSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecSrvcSpec.GetProdSpecSrvcSpecResponse;
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
@RequestMapping(Paths.apiPrefix + "PROD_SPEC_SRVC_SPEC")
@AllArgsConstructor
public class ProdSpecSrvcSpecController {
   private IProdSpecSrvcSpecService iProdSpecSrvcSpecService;

   @GetMapping("/get-all")
   public DataResult<List<GetAllProdSpecSrvcSpecResponse>> getAll(){
      return this.iProdSpecSrvcSpecService.getAll();
   }

   @GetMapping("/get-all-with-pagination")
   public DataResult<Page<List<GetAllProdSpecSrvcSpecResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
      Pageable pageable = PageRequest.of(page-1,pageSize);
      return this.iProdSpecSrvcSpecService.getAllWithPagination(pageable);
   }
   @GetMapping("/get-by-id")
   public DataResult<GetProdSpecSrvcSpecResponse> getById(@RequestParam Long prodSpecSrvcSpecId) {return this.iProdSpecSrvcSpecService.getById(prodSpecSrvcSpecId);}
}
