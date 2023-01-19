package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.business.constants.Paths;
import com.etiya.crmlite.business.dtos.request.cam.addr.CreateAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.addr.DeleteAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.addr.UpdateAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.cust.CreateCustRequest;
import com.etiya.crmlite.business.dtos.response.cam.addr.GetAddrResponse;
import com.etiya.crmlite.business.dtos.response.cam.addr.GetAllAddrResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.etiya.crmlite.business.abstracts.cam.IAddrService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "ADDR")
@AllArgsConstructor
public class AddrController {
    private IAddrService iAddrService;

    @GetMapping("/get-all")
    public DataResult<List<GetAllAddrResponse>> getAll() {
        return this.iAddrService.getAll();
    }

    @GetMapping("/get-all-with-pagination")
    public DataResult<Page<List<GetAllAddrResponse>>> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return this.iAddrService.getAllWithPagination(pageable);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetAddrResponse> getById(@RequestParam Long addrId) {
        return this.iAddrService.getById(addrId);
    }

    @PostMapping("/delete-addr")
    public ResponseEntity<Result> delete(DeleteAddrRequest deleteAddrRequest) {
        return new ResponseEntity<>(iAddrService.deleteAddr(deleteAddrRequest), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/update-addr")
    public ResponseEntity<DataResult<UpdateAddrRequest>> update(UpdateAddrRequest updateAddrRequest) {
        return new ResponseEntity<>(iAddrService.updateAddr(updateAddrRequest), HttpStatus.OK);
    }

    @PostMapping("/create-addr")
    public Result add(@RequestBody @Valid CreateAddrRequest createAddrRequest) {
        return this.iAddrService.addAddr(createAddrRequest);
    }
}
