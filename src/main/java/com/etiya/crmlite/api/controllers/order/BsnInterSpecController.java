package com.etiya.crmlite.api.controllers.order;

import com.etiya.crmlite.business.abstracts.order.IBsnInterSpecService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.order.bsnInterItem.GetAllBsnInterItemResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSpec.GetAllBsnInterSpecResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSpec.GetBsnInterSpecResponse;
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
@RequestMapping(Paths.apiPrefix + "BSN_INTER_SPEC")
@AllArgsConstructor
public class BsnInterSpecController {
    private IBsnInterSpecService iBsnInterSpecService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllBsnInterSpecResponse>> getAll(){
        return this.iBsnInterSpecService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllBsnInterSpecResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return this.iBsnInterSpecService.getAllWithPagination(pageable);
    }
    @GetMapping("/get-by-id")
    public DataResult<GetBsnInterSpecResponse> getById(@RequestParam Long bsnInterSpecId) {return this.iBsnInterSpecService.getById(bsnInterSpecId);}
}
