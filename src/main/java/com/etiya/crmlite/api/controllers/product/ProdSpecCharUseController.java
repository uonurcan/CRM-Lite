package com.etiya.crmlite.api.controllers.product;

import com.etiya.crmlite.business.abstracts.product.IProdSpecCharUseService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.product.prodRel.GetAllProdRelResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecCharUse.GetAllProdSpecCharUseResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecCharUse.GetProdSpecCharUseResponse;
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
@RequestMapping(Paths.apiPrefix + "PROD_SPEC_CHAR_USE")
@AllArgsConstructor
public class ProdSpecCharUseController {
   private IProdSpecCharUseService iProdSpecCharUseService;

   @GetMapping("/get-all")
   public DataResult<List<GetAllProdSpecCharUseResponse>> getAll(){
      return this.iProdSpecCharUseService.getAll();
   }

   @GetMapping("/get-all-with-pagination")
   public DataResult<Page<List<GetAllProdSpecCharUseResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
      Pageable pageable = PageRequest.of(page-1,pageSize);
      return this.iProdSpecCharUseService.getAllWithPagination(pageable);
   }
   @GetMapping("/get-by-id")
   public DataResult<GetProdSpecCharUseResponse> getById(@RequestParam Long prodSpecCharUseId) {return this.iProdSpecCharUseService.getById(prodSpecCharUseId);}
}
