package com.etiya.crmlite.api.controllers.order;

import com.etiya.crmlite.business.abstracts.order.IBsnInterService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.common.srvcSpec.GetAllSrvcSpecResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetAllBsnInterResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetBsnInterResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "BSN_INTER")
@AllArgsConstructor
public class BsnInterController {
    private IBsnInterService iBsnInterService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllBsnInterResponse>> getAll(){
        return this.iBsnInterService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllBsnInterResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return this.iBsnInterService.getAllWithPagination(pageable);
    }
    @GetMapping("/get-by-id")
    public DataResult<GetBsnInterResponse> getById(@RequestParam Long bsnInterId) {return this.iBsnInterService.getById(bsnInterId);}

    @PostMapping("/start-new-sale")
    public ResponseEntity<Result> startNewSale(@RequestParam Long custId){
        return new ResponseEntity<>(iBsnInterService.startNewSale(custId), HttpStatus.CREATED);
    }
}
