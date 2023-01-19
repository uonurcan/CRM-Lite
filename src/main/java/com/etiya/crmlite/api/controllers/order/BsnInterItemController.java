package com.etiya.crmlite.api.controllers.order;

import com.etiya.crmlite.business.abstracts.order.IBsnInterItemService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetAllBsnInterResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterItem.GetAllBsnInterItemResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterItem.GetBsnInterItemResponse;
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
@RequestMapping(Paths.apiPrefix + "BSN_INTER_ITEM")
@AllArgsConstructor
public class BsnInterItemController {
    private IBsnInterItemService iBsnInterItemService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllBsnInterItemResponse>> getAll(){
        return this.iBsnInterItemService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllBsnInterItemResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return this.iBsnInterItemService.getAllWithPagination(pageable);
    }
    @GetMapping("/get-by-id")
    public DataResult<GetBsnInterItemResponse> getById(@RequestParam Long bsnInterItemId) {return this.iBsnInterItemService.getById(bsnInterItemId);}

}
