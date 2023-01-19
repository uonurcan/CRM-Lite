package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.IAddrService;
import com.etiya.crmlite.business.abstracts.cam.ICustAcctProdInvlService;
import com.etiya.crmlite.business.abstracts.cam.ICustAcctService;
import com.etiya.crmlite.business.abstracts.cam.ICustService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.request.cam.custAcct.CreateCustAcctRequest;
import com.etiya.crmlite.business.dtos.request.cam.custAcct.DeleteCustAcctRequest;
import com.etiya.crmlite.business.dtos.request.cam.custAcct.UpdateCustAcctRequest;
import com.etiya.crmlite.business.dtos.response.cam.custAcct.GetAllCustAcctResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcct.GetCustAcctResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlFromACustResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlResponse;
import com.etiya.crmlite.core.utilities.enums.ActvSts;
import com.etiya.crmlite.core.utilities.enums.StatusCode;
import com.etiya.crmlite.core.utilities.enums.TpVals;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.core.utilities.results.SuccessResult;
import com.etiya.crmlite.entities.concretes.cam.Addr;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.entities.concretes.cam.CustAcct;
import com.etiya.crmlite.repository.abstracts.cam.ICustAcctRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustAcctManager implements ICustAcctService {
    private ICustAcctRepository iCustAcctRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;
    private ICustService iCustService;
    private IAddrService iAddrService;
    private ICustAcctProdInvlService iCustAcctProdInvlService;

    @Override
    public DataResult<List<GetAllCustAcctResponse>> getAll() {
        List<CustAcct> custAccts = this.iCustAcctRepository.findAll();
        List<GetAllCustAcctResponse> response = custAccts.stream().map(custAcct -> iModelMapperService.forResponse().
                map(custAcct, GetAllCustAcctResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllCustAcctResponse>>(response,
                iMessageSourceService.getMessage(Messages.CustAcct.custAcctListed));
    }

    @Override
    public DataResult<GetCustAcctResponse> getById(Long custAcctId) {
        CustAcct custAcct = checkIfCustAcctExistsById(custAcctId);
        GetCustAcctResponse response = iModelMapperService
                .forResponse().map(custAcct, GetCustAcctResponse.class);
        return new SuccessDataResult<GetCustAcctResponse>(response, iMessageSourceService.getMessage(Messages.CustAcct.custAcctReceived));
    }

    private CustAcct checkIfCustAcctExistsById(Long custAcctId) {
        CustAcct currentCustAcct;
        try {
            currentCustAcct = iCustAcctRepository.findById(custAcctId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.CustAcct.custAcctNotExistWithId));
        }
        return currentCustAcct;
    }

    @Override
    public DataResult<Page<List<GetAllCustAcctResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllCustAcctResponse>> response =
                this.iCustAcctRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllCustAcctResponse>>>
                (response, iMessageSourceService.getMessage(Messages.CustAcct.custAcctListed));
    }

    @Override
    public void addCustAcctFromInd(CustAcct custAcct) {
        this.iCustAcctRepository.save(custAcct);
    }

    @Transactional
    @Override
    public Result add(CreateCustAcctRequest createCustAcctRequest) {
        CustAcct custAcct = CustAcct.builder()
                .cust(iCustService.getCustById(createCustAcctRequest.getCustId()))
                .acctName(createCustAcctRequest.getAcctName())
                .stId(StatusCode.CUST_ACCT_ACTV)
                .acctTpId(TpVals.ACCOUNT_TYPE_CUST_ACCT)
                .descr(createCustAcctRequest.getDescr())
                .build();

        CustAcct savedCustAcct = this.iCustAcctRepository.save(custAcct);
        custAcct.setAcctNo(String.valueOf(savedCustAcct.getCustAcctId()));
        this.iCustAcctRepository.save(custAcct);
        Cust cust = this.iCustService.getCustById(createCustAcctRequest.getCustId());

        createAddr(createCustAcctRequest, cust.getPartyRole().getParty().getPartyId());
        return new SuccessResult(iMessageSourceService.getMessage(Messages.CustAcct.custAcctAdded));
    }

    private void createAddr(CreateCustAcctRequest createCustAcctRequest,Long RowId) {

        Addr addr = Addr.builder()
                .cityName(createCustAcctRequest.getCityName())
                .addrDesc(createCustAcctRequest.getAddrDesc())
                .bldgName(createCustAcctRequest.getBldgName())
                .strtName(createCustAcctRequest.getStrtName())
                .cntryName("Turkey")
                .isActv(ActvSts.ACTIVE)
                .rowId(RowId)
                .dataTpId(TpVals.PARTY)
                .build();
        this.iAddrService.save(addr);
    }

    @Override
    public Result update(UpdateCustAcctRequest updateCustAcctRequest) {
        CustAcct custAcct = this.iCustAcctRepository.findById(updateCustAcctRequest.getCustAcctId()).orElseThrow();
        CustAcct custAcctToUpdate = CustAcct.builder()
                .custAcctId(custAcct.getCustAcctId())
                .cust(custAcct.getCust())
                .acctNo(custAcct.getAcctNo())
                .acctName(updateCustAcctRequest.getAcctName())
                .stId(custAcct.getStId())
                .acctTpId(custAcct.getAcctTpId())
                .descr(updateCustAcctRequest.getDescr()).build();
        custAcctToUpdate.setCUser(custAcct.getCUser());
        custAcctToUpdate.setCDate(custAcct.getCDate());
        this.iCustAcctRepository.save(custAcctToUpdate);
        updateAddress(updateCustAcctRequest);
        return new SuccessResult(iMessageSourceService.getMessage(Messages.CustAcct.custAcctUpdated));
    }

    private void updateAddress(UpdateCustAcctRequest updateCustAcctRequest) {
        this.iAddrService.updateAddrForCustBillAcct(updateCustAcctRequest.getUpdateAddrRequest());
    }

    @Override
    public Result delete(DeleteCustAcctRequest deleteCustAcctRequest) {
        CustAcct custAcct = this.iCustAcctRepository.findById(deleteCustAcctRequest.getCustAcctId()).orElseThrow();
        checkIfExistsActvProd(custAcct.getCustAcctId());
        CustAcct custAcctToDelete = custAcct;
        custAcctToDelete.setStId(StatusCode.CUST_ACCT_PASS);
        this.iCustAcctRepository.save(custAcctToDelete);
        return new SuccessResult(iMessageSourceService.getMessage(Messages.CustAcct.custAcctDeleted));
    }

    private void checkIfExistsActvProd(Long customerId) {
        DataResult<List<GetCustAcctProdInvlFromACustResponse>> result
                = this.iCustAcctProdInvlService.getActvProdOfBillAcct(customerId);
        if (result.getData().size() > 0) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.CustAcct.custAcctWithActvProd));
        }
    }
}