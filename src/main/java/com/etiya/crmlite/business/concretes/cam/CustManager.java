package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.*;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.request.cam.cust.CreateCustRequest;
import com.etiya.crmlite.business.dtos.request.cam.cust.DeleteCustRequest;
import com.etiya.crmlite.business.dtos.response.cam.cust.GetAllCustResponse;
import com.etiya.crmlite.business.dtos.response.cam.cust.GetCustResponse;
import com.etiya.crmlite.business.dtos.response.cam.cust.SearchCustResponse;
import com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl.GetCustAcctProdInvlResponse;
import com.etiya.crmlite.core.utilities.enums.ActvSts;
import com.etiya.crmlite.core.utilities.enums.StatusCode;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.*;
import com.etiya.crmlite.entities.concretes.cam.*;
import com.etiya.crmlite.repository.abstracts.cam.ICustRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustManager implements ICustService {
    private ICustRepository iCustRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;
    private IIndService iIndService;
    private ICustAcctProdInvlService iCustAcctProdInvlService;

    public CustManager(ICustRepository iCustRepository, IModelMapperService iModelMapperService, IMessageSourceService iMessageSourceService, @Lazy IIndService iIndService, ICustAcctProdInvlService iCustAcctProdInvlService) {
        this.iCustRepository = iCustRepository;
        this.iModelMapperService = iModelMapperService;
        this.iMessageSourceService = iMessageSourceService;
        this.iIndService = iIndService;
        this.iCustAcctProdInvlService = iCustAcctProdInvlService;
    }

    @Override
    public DataResult<List<GetAllCustResponse>> getAll() {
        List<Cust> custs = this.iCustRepository.findAll();
        List<GetAllCustResponse> response = custs.stream().map(cust -> iModelMapperService.forResponse().
                map(cust, GetAllCustResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllCustResponse>>(response,
                iMessageSourceService.getMessage(Messages.Cust.custListed));
    }

    @Override
    public DataResult<GetCustResponse> getById(Long custId) {
        Cust cust = checkIfCustExistsById(custId);
        GetCustResponse response = iModelMapperService
                .forResponse().map(cust, GetCustResponse.class);
        return new SuccessDataResult<GetCustResponse>(response, iMessageSourceService.getMessage(Messages.Cust.custReceived));
    }

    private Cust checkIfCustExistsById(Long custId) {
        Cust currentCust;
        try {
            currentCust = iCustRepository.findById(custId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.Cust.custNotExistWithId));
        }
        return currentCust;
    }

    @Override
    public DataResult<List<SearchCustResponse>> searchCust(Long nationalityId, Long customerId,
                                                           String accountNumber, String gsmNumber,
                                                           String firstName, String lastName,
                                                           Long orderNumber) {
        List<SearchCustResponse> results = iCustRepository.findCustBySearchFilters(nationalityId,
                customerId, accountNumber, gsmNumber, firstName, lastName, orderNumber);
        List<SearchCustResponse> responses = mapSearchCustResponses(results);
        return checkCustExistsByFilter(results, responses);
    }

    @Override
    public Result add(CreateCustRequest createCustRequest) {
        PartyRole partyRole = PartyRole.builder().partyRoleId(createCustRequest.getPartyRoleId()).build();
        CustTp custTp = CustTp.builder().custTpId(createCustRequest.getCustTpId()).build();
        Cust cust = Cust.builder()
                .custTp(custTp)
                .partyRole(partyRole)
                .stId(StatusCode.CUST_ACTV)
                .build();
        save(cust);

        return new SuccessResult(iMessageSourceService.getMessage(Messages.Cust.custListed));
    }

    private List<SearchCustResponse> mapSearchCustResponses(List<SearchCustResponse> results) {
        List<SearchCustResponse> responses = results.stream().map(result -> SearchCustResponse.builder()
                .natId(result.getNatId())
                .custId(result.getCustId())
                .roleName(result.getRoleName())
                .frstName(result.getFrstName())
                .mName(result.getMName())
                .lstName(result.getLstName())
                .build()).collect(Collectors.toList());
        return responses;
    }

    private DataResult<List<SearchCustResponse>> checkCustExistsByFilter(List<SearchCustResponse> results,
                                                                         List<SearchCustResponse>
                                                                                 responses) {
        if (results.size() == 0) {
            return new ErrorDataResult<>(iMessageSourceService.getMessage(Messages.Cust.custNotExistWithId));
        } else {
            return new SuccessDataResult<>(responses, iMessageSourceService.
                    getMessage(Messages.Cust.custReceived));
        }
    }

    @Override
    public DataResult<Page<List<GetAllCustResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllCustResponse>> response =
                this.iCustRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllCustResponse>>>
                (response, iMessageSourceService.getMessage(Messages.Cust.custListed));
    }

    @Override
    public void save(Cust cust) {
        this.iCustRepository.save(cust);
    }

    @Transactional
    @Override
    public Result delete(DeleteCustRequest deleteCustRequest) {
        checkIfExistsActiveProduct(deleteCustRequest.getCustId());
        Cust cust = this.iCustRepository.findById(deleteCustRequest.getCustId()).get();
        Cust custToDelete = cust;
        custToDelete.setStId(StatusCode.CUST_PASS);
        this.iCustRepository.save(custToDelete);
        deleteIndFromCust(deleteCustRequest.getCustId());
        return new SuccessResult(iMessageSourceService.getMessage(Messages.Cust.custListed));
    }

    @Override
    public void addNewCustFromInd(Cust cust) {
        this.iCustRepository.save(cust);
    }

    private void deleteIndFromCust(Long id){
        Ind ind = this.iCustRepository.getIndByCustId(id);
        Ind indToDelete = Ind.builder()
                .indId(ind.getIndId())
                .mName(ind.getMName())
                .party(ind.getParty())
                .brthDate(ind.getBrthDate())
                .gendrId(ind.getGendrId())
                .lstName(ind.getLstName())
                .frstName(ind.getFrstName())
                .fthrName(ind.getFthrName())
                .mthrName(ind.getMthrName())
                .stId(StatusCode.IND_DEL)
                .natId(ind.getNatId())
                .build();
        this.iIndService.deleteIndFromCust(indToDelete);
    }

    private void checkIfExistsActiveProduct(Long custId) {
        DataResult<List<GetCustAcctProdInvlResponse>> result = this.iCustAcctProdInvlService.getActvProdOfCust(custId);
        if (result.getData().size() > 0) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.Cust.custNotExistWithId));
        }

    }
    @Override
    public Cust getCustById(Long id) {
        return checkIfCustExistsById(id);
    }
}