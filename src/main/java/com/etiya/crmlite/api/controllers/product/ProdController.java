package com.etiya.crmlite.api.controllers.product;

import com.etiya.crmlite.business.abstracts.product.IProdService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.product.prod.GetAllProdResponse;
import com.etiya.crmlite.business.dtos.response.product.prod.GetProdResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCharVal.GetAllProdCharValResponse;
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
@RequestMapping(Paths.apiPrefix + "PROD")
@AllArgsConstructor
public class ProdController {
   private IProdService iProdService;

   @GetMapping("/get-all")
   public DataResult<List<GetAllProdResponse>> getAll(){
      return this.iProdService.getAll();
   }

   @GetMapping("/get-all-with-pagination")
   public DataResult<Page<List<GetAllProdResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
      Pageable pageable = PageRequest.of(page-1,pageSize);
      return this.iProdService.getAllWithPagination(pageable);
   }
   @GetMapping("/get-by-id")
   public DataResult<GetProdResponse> getById(@RequestParam Long prodId) {return this.iProdService.getById(prodId);}
}
