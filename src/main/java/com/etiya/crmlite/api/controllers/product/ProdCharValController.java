package com.etiya.crmlite.api.controllers.product;

import com.etiya.crmlite.business.abstracts.product.IProdCharValService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr.GetAllProdCatalProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCharVal.GetAllProdCharValResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCharVal.GetProdCharValResponse;
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
@RequestMapping(Paths.apiPrefix + "PROD_CHAR_VAL")
@AllArgsConstructor
public class ProdCharValController {
   private IProdCharValService iProdCharValService;

   @GetMapping("/get-all")
   public DataResult<List<GetAllProdCharValResponse>> getAll(){
      return this.iProdCharValService.getAll();
   }

   @GetMapping("/get-all-with-pagination")
   public DataResult<Page<List<GetAllProdCharValResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
      Pageable pageable = PageRequest.of(page-1,pageSize);
      return this.iProdCharValService.getAllWithPagination(pageable);
   }
   @GetMapping("/get-by-id")
   public DataResult<GetProdCharValResponse> getById(@RequestParam Long prodCharValId) {return this.iProdCharValService.getById(prodCharValId);}
}
