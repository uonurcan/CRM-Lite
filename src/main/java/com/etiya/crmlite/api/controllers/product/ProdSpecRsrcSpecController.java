package com.etiya.crmlite.api.controllers.product;

import com.etiya.crmlite.business.abstracts.product.IProdSpecRsrcSpecService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.product.prodSpec.GetAllProdSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecRsrcSpec.GetAllProdSpecRsrcSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecRsrcSpec.GetProdSpecRsrcSpecResponse;
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
@RequestMapping(Paths.apiPrefix + "PROD_SPEC_RSRC_SPEC")
@AllArgsConstructor
public class ProdSpecRsrcSpecController {
   private IProdSpecRsrcSpecService iProdSpecRsrcSpecService;

   @GetMapping("/get-all")
   public DataResult<List<GetAllProdSpecRsrcSpecResponse>> getAll(){
      return this.iProdSpecRsrcSpecService.getAll();
   }

   @GetMapping("/get-all-with-pagination")
   public DataResult<Page<List<GetAllProdSpecRsrcSpecResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
      Pageable pageable = PageRequest.of(page-1,pageSize);
      return this.iProdSpecRsrcSpecService.getAllWithPagination(pageable);
   }
   @GetMapping("/get-by-id")
   public DataResult<GetProdSpecRsrcSpecResponse> getById(@RequestParam Long prodSpecRsrcSpecId) {return this.iProdSpecRsrcSpecService.getById(prodSpecRsrcSpecId);}
}
