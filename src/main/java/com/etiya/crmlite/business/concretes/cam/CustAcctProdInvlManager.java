package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.ICustAcctProdInvlService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetAllCustAcctProdInvlResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlFromACustResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.ErrorDataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.cam.CustAcctProdInvl;
import com.etiya.crmlite.repository.abstracts.cam.ICustAcctProdInvlRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustAcctProdInvlManager implements ICustAcctProdInvlService {
    private ICustAcctProdInvlRepository iCustAcctProdInvlRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllCustAcctProdInvlResponse>> getAll() {
        List<CustAcctProdInvl> custAcctProdInvls = this.iCustAcctProdInvlRepository.findAll();
        List<GetAllCustAcctProdInvlResponse> response = custAcctProdInvls.stream().map(custAcctProdInvl -> iModelMapperService.forResponse().
                map(custAcctProdInvl, GetAllCustAcctProdInvlResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllCustAcctProdInvlResponse>>(response,
                iMessageSourceService.getMessage(Messages.CustAcctProdInvl.custAcctProdInvlListed));
    }

    @Override
    public DataResult<GetCustAcctProdInvlResponse> getById(Long custAcctProdInvlId) {
        CustAcctProdInvl custAcctProdInvl = iCustAcctProdInvlRepository.findById(custAcctProdInvlId).orElseThrow();
        GetCustAcctProdInvlResponse response = iModelMapperService
                .forResponse().map(custAcctProdInvl, GetCustAcctProdInvlResponse.class);
        return new SuccessDataResult<GetCustAcctProdInvlResponse>(response, iMessageSourceService.getMessage(Messages.CustAcctProdInvl.custAcctProdInvlReceived));
    }

    @Override
    public DataResult<List<GetCustAcctProdInvlResponse>> getActvProdOfCust(Long custId) {
        List<GetCustAcctProdInvlResponse> result = this.iCustAcctProdInvlRepository.getActvProdOfCust(custId);
        if (result.size() > 0) {
            return new ErrorDataResult<>(result, iMessageSourceService.getMessage(Messages.CustAcctProdInvl.custAcctProdInvlListed));
        }
        return new SuccessDataResult<>(result, iMessageSourceService.getMessage(Messages.CustAcctProdInvl.custAcctProdInvlListed));

    }

    @Override
    public DataResult<List<GetCustAcctProdInvlFromACustResponse>> getActvProdOfBillAcct(Long custAcctId) {
        List<GetCustAcctProdInvlFromACustResponse> result = this.iCustAcctProdInvlRepository.
                getActvProdOfBillAcct(custAcctId);
        return new SuccessDataResult<>(result,iMessageSourceService.getMessage(Messages.CustAcctProdInvl.custAcctProdInvlListed));
    }



    @Override
    public DataResult<Page<List<GetAllCustAcctProdInvlResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllCustAcctProdInvlResponse>> response =
                this.iCustAcctProdInvlRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllCustAcctProdInvlResponse>>>
                (response, iMessageSourceService.getMessage(Messages.CustAcctProdInvl.custAcctProdInvlListed));
    }
}
