package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.business.abstracts.cam.ICntcMediumService;
import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.request.cam.addr.DeleteAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.cntcMedium.CreateCntcMediumRequest;
import com.etiya.crmlite.business.dtos.request.cam.cntcMedium.DeleteCntcMediumRequest;
import com.etiya.crmlite.business.dtos.request.cam.cntcMedium.UpdateCntcMediumRequest;
import com.etiya.crmlite.business.dtos.response.cam.cntcMedium.GetAllCntcMediumResponse;
import com.etiya.crmlite.business.dtos.response.cam.cntcMedium.GetCntcMediumResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "CNTC_MEDIUM")
@AllArgsConstructor
public class CntcMediumController {
    private ICntcMediumService iCntcMediumService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllCntcMediumResponse>> getAll() {
        return this.iCntcMediumService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllCntcMediumResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return this.iCntcMediumService.getAllWithPagination(pageable);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetCntcMediumResponse> getById(@RequestParam Long cntMediumId) {
        return this.iCntcMediumService.getById(cntMediumId);
    }

    @RequestMapping(value = "/add-cntc-medium", method = RequestMethod.PUT)
    public Result add(@RequestBody @Valid CreateCntcMediumRequest createCntcMediumRequest) {
        return this.iCntcMediumService.add(createCntcMediumRequest);
    }


    @RequestMapping(value = "/update-cntc-medium", method = RequestMethod.POST)
    public Result update(@RequestBody UpdateCntcMediumRequest updateCntcMediumRequest) {
        return this.iCntcMediumService.update(updateCntcMediumRequest);
    }

    @PostMapping("/delete-cntc-medium")
    public ResponseEntity<Result> delete(DeleteCntcMediumRequest deleteCntcMediumRequest) {
        return new ResponseEntity<>(iCntcMediumService.delete(deleteCntcMediumRequest), HttpStatus.NO_CONTENT);
    }
}

