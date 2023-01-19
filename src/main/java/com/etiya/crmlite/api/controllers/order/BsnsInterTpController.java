package com.etiya.crmlite.api.controllers.order;

import com.etiya.crmlite.business.abstracts.order.IBsnInterTpService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSt.GetAllBsnInterStResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterTp.GetAllBsnInterTpResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterTp.GetBsnInterTpResponse;
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
@RequestMapping(Paths.apiPrefix + "BSN_INTER_TP")
@AllArgsConstructor
public class BsnsInterTpController {
    private IBsnInterTpService iBsnInterTpService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllBsnInterTpResponse>> getAll(){
        return this.iBsnInterTpService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllBsnInterTpResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return this.iBsnInterTpService.getAllWithPagination(pageable);
    }
    @GetMapping("/get-by-id")
    public DataResult<GetBsnInterTpResponse> getById(@RequestParam Long bsnInterTpId) {return this.iBsnInterTpService.getById(bsnInterTpId);}
}
