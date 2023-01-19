package com.etiya.crmlite.api.controllers.product;

import com.etiya.crmlite.business.abstracts.product.IProdCatalProdOfrService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr.GetAllProdCatalProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr.GetProdCatalProdOfrResponse;
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
@RequestMapping(Paths.apiPrefix + "PROD_CATAL_PROD_OFR")
@AllArgsConstructor
public class ProdCatalProdOfrController {
   private IProdCatalProdOfrService iProdCatalProdOfrService;

   @GetMapping("/get-all")
   public DataResult<List<GetAllProdCatalProdOfrResponse>> getAll(){
      return this.iProdCatalProdOfrService.getAll();
   }

   @GetMapping("/get-all-with-pagination")
   public DataResult<Page<List<GetAllProdCatalProdOfrResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
      Pageable pageable = PageRequest.of(page-1,pageSize);
      return this.iProdCatalProdOfrService.getAllWithPagination(pageable);
   }

   @GetMapping("/get-by-id")
   public DataResult<GetProdCatalProdOfrResponse> getById(@RequestParam Long prodCatalProdOfrId) {return this.iProdCatalProdOfrService.getById(prodCatalProdOfrId);}
}
