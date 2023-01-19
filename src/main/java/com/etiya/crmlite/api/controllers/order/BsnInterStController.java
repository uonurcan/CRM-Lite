package com.etiya.crmlite.api.controllers.order;

import com.etiya.crmlite.business.abstracts.order.IBsnInterStService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSpec.GetAllBsnInterSpecResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSt.GetAllBsnInterStResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSt.GetBsnInterStResponse;
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
@RequestMapping(Paths.apiPrefix + "BSN_INTER_ST")
@AllArgsConstructor
public class BsnInterStController {
  private IBsnInterStService iBsnInterStService;

  @GetMapping("/get-all")
  public DataResult<List<GetAllBsnInterStResponse>> getAll(){
    return this.iBsnInterStService.getAll();
  }

  @GetMapping("/get-all-with-pagination")
  public DataResult<Page<List<GetAllBsnInterStResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
    Pageable pageable = PageRequest.of(page-1,pageSize);
    return this.iBsnInterStService.getAllWithPagination(pageable);
  }
  @GetMapping("/get-by-id")
  public DataResult<GetBsnInterStResponse> getById(@RequestParam Long bsnInterStId) {return this.iBsnInterStService.getById(bsnInterStId);}
}
