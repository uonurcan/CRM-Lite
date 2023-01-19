package com.etiya.crmlite.api.controllers.product;

import com.etiya.crmlite.business.abstracts.product.IProdCatalService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr.GetAllCmpgProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCatal.GetAllProdCatalResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCatal.GetProdCatalResponse;
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
@RequestMapping(Paths.apiPrefix + "PROD_CATAL")
@AllArgsConstructor
public class ProdCatalController {
   private IProdCatalService iProdCatalService;

   @GetMapping("/get-all")
   public DataResult<List<GetAllProdCatalResponse>> getAll(){
      return this.iProdCatalService.getAll();
   }

   @GetMapping("/get-all-with-pagination")
   public DataResult<Page<List<GetAllProdCatalResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
      Pageable pageable = PageRequest.of(page-1,pageSize);
      return this.iProdCatalService.getAllWithPagination(pageable);
   }
   @GetMapping("/get-by-id")
   public DataResult<GetProdCatalResponse> getById(@RequestParam Long prodCatalId) {return this.iProdCatalService.getById(prodCatalId);}
}
