package com.etiya.crmlite.api.controllers.product;

import com.etiya.crmlite.business.abstracts.product.IProdOfrService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.product.prod.GetAllProdResponse;
import com.etiya.crmlite.business.dtos.response.product.prodOfr.GetAllProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.prodOfr.GetProdOfrResponse;
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
@RequestMapping(Paths.apiPrefix + "PROD_OFR")
@AllArgsConstructor
public class ProdOfrController {
   private IProdOfrService iProdOfrService;

   @GetMapping("/get-all")
   public DataResult<List<GetAllProdOfrResponse>> getAll(){
      return this.iProdOfrService.getAll();
   }

   @GetMapping("/get-all-with-pagination")
   public DataResult<Page<List<GetAllProdOfrResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
      Pageable pageable = PageRequest.of(page-1,pageSize);
      return this.iProdOfrService.getAllWithPagination(pageable);
   }
   @GetMapping("/get-by-id")
   public DataResult<GetProdOfrResponse> getById(@RequestParam Long prodOfrId) {return this.iProdOfrService.getById(prodOfrId);}
}
