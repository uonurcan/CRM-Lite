package com.etiya.crmlite.api.controllers.common;

import com.etiya.crmlite.business.abstracts.common.IGnlCharValService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetAllGnlCharResponse;
import com.etiya.crmlite.business.dtos.response.common.gnlCharVal.*;
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
@RequestMapping(Paths.apiPrefix + "GNL_CHAR_VAL")
@AllArgsConstructor
public class GnlCharValController {
    private IGnlCharValService iGnlCharValService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllGnlCharValResponse>> getAll(){
        return this.iGnlCharValService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllGnlCharValResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return this.iGnlCharValService.getAllWithPagination(pageable);
    }
    @GetMapping("/get-by-id")
    public DataResult<GetGnlCharValResponse> getById(@RequestParam Long gnlCharId) {return this.iGnlCharValService.getById(gnlCharId);}
}
