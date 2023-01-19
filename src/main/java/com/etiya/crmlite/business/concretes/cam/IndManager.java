package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.*;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.request.cam.addr.CreateAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.ind.CreateIndRequest;
import com.etiya.crmlite.business.dtos.request.cam.ind.UpdateIndRequest;
import com.etiya.crmlite.core.utilities.enums.*;
import com.etiya.crmlite.business.dtos.response.cam.ind.GetAllIndResponse;
import com.etiya.crmlite.business.dtos.response.cam.ind.GetIndResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.core.utilities.results.SuccessResult;
import com.etiya.crmlite.entities.concretes.cam.*;
import com.etiya.crmlite.repository.abstracts.cam.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class IndManager implements IIndService {
    private IIndRepository iIndRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;
    private ICntcMediumService iCntcMediumService;
    private IAddrService iAddrService;
    private final ICustAcctService iCustAcctService;
    private final IPartyRoleService iPartyRoleService;
    private final IPartyService iPartyService;
    private final ICustService iCustService;

    @Override
    public DataResult<List<Ind>> getAll() {
        List<Ind> inds = this.iIndRepository.findAll();
        List<Ind> response = inds.stream().map(ind -> iModelMapperService.forResponse().
                map(ind, Ind.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<Ind>>(response,
                iMessageSourceService.getMessage(Messages.Ind.indListed));
    }

    @Override
    public DataResult<GetIndResponse> getById(Long indId) {
        Ind ind = checkIfIndExistsById(indId);
        GetIndResponse response = iModelMapperService
                .forResponse().map(ind, GetIndResponse.class);
        return new SuccessDataResult<GetIndResponse>(response, iMessageSourceService.getMessage(Messages.Ind.indReceived));
    }

    private Ind checkIfIndExistsById(Long indId) {
        Ind currentInd;
        try {
            currentInd = iIndRepository.findById(indId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.Ind.indNotExistWithId));
        }
        return currentInd;
    }

    @Override
    public DataResult<Page<List<GetAllIndResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllIndResponse>> response =
                this.iIndRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllIndResponse>>>
                (response, iMessageSourceService.getMessage(Messages.Ind.indListed));
    }

    @Override
    public void save(Ind ind) {
        this.iIndRepository.save(ind);
    }

    @Override
    public Result updateInd(UpdateIndRequest updateIndRequest) {
        Ind ind = iIndRepository.findById(updateIndRequest.getIndId()).orElseThrow();
        ind.setFrstName(updateIndRequest.getFrstName());
        ind.setMName(updateIndRequest.getMName());
        ind.setLstName(updateIndRequest.getLstName());
        ind.setBrthDate(updateIndRequest.getBrthDate());
        ind.setGendrId(updateIndRequest.getGendrId());
        ind.setMthrName(updateIndRequest.getMthrName());
        ind.setFthrName(updateIndRequest.getFthrName());
        ind.setNatId(updateIndRequest.getNatId());
        this.iIndRepository.save(ind);
        getByIndividualId(updateIndRequest.getIndId());
        return new SuccessResult();
    }

    private void getByIndividualId(Long id) {
        Cust cust = this.iIndRepository.getByIndividualId(id);
        Cust custToUpdate = Cust.builder().custId(cust.getCustId())
                .custTp(cust.getCustTp())
                .partyRole(cust.getPartyRole())
                .stId(cust.getStId())
                .build();

        iCustService.save(custToUpdate);
    }

    @Transactional
    @Override
    public Result add(CreateIndRequest createIndRequest) {

        checkIfCustExistsByNatId(createIndRequest.getNatId());
        Ind createdInd = createInd(createIndRequest);
        createAddr(createdInd.getParty().getPartyId(),createIndRequest);
        addCntcMediumGsm(createdInd.getParty().getPartyId(), createIndRequest.getMobilePhone());
        addCntcMediumEmail(createdInd.getParty().getPartyId(), createIndRequest.getEMail());
        addCntcMediumHomePhone(createdInd.getParty().getPartyId(), createIndRequest.getHomePhone());
        addCntcMediumFax(createdInd.getParty().getPartyId(), createIndRequest.getFax());

        return new SuccessResult(iMessageSourceService.getMessage(Messages.Ind.indAdded));
    }

    private void checkIfCustExistsByNatId(Long nationalityId) {
        Ind ind = this.iIndRepository.findByNatId(nationalityId);
        if (ind != null) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.Ind.indExistWithNatId));
        }

    }

    private void createAddr(Long rowId,CreateIndRequest createIndRequest) {
        Addr addr = Addr.builder()
                .addrDesc(createIndRequest.getAddressDescription())
                .cityName(createIndRequest.getCityName())
                .strtName(createIndRequest.getStreetName())
                .rowId(rowId)
                .bldgName(createIndRequest.getBuildingName())
                .isActv(ActvSts.ACTIVE)
                .dataTpId(TpVals.PARTY)
                .cntryName("Turkey")
                //TODO BLDGID, STRTID
                .build();
        this.iAddrService.save(addr);

    }

    private Ind createInd(CreateIndRequest createIndRequest) {
        Ind individual = Ind.builder()
                .brthDate(createIndRequest.getBrthDate())
                .fthrName(createIndRequest.getFthrName())
                .frstName(createIndRequest.getFrstName())
                .gendrId(createIndRequest.getGendrId())
                .lstName(createIndRequest.getLstName())
                .mthrName(createIndRequest.getMthrName())
                .mName(createIndRequest.getMName())
                .natId(createIndRequest.getNatId())
                .stId(StatusCode.IND_ACTV)
                .party(addNewCustAcct().getCust().getPartyRole().getParty())
                .build();
        this.iIndRepository.save(individual);
        return individual;
    }

    private Party addNewParty() {
        Party party = Party.builder()
                .partyTpId(TpVals.TYPE_VALUE_PARTY_IND)
                .stId(StatusCode.PARTY_ACTV)
                .build();
        this.iPartyService.addPartyFromInd(party);
        return party;
    }

    private PartyRole addNewPartyRole() {
        PartyRoleTp partyRoleTp = PartyRoleTp.builder().partyRoleTpId(TpVals.PARTY_ROLE_TP_CUST).build();
        Party party = addNewParty();
        PartyRole partyRole = PartyRole.builder()
                .party(party)
                .partyRoleTp(partyRoleTp)
                .stId(StatusCode.PARTY_ROLE_ACTV)
                .build();
        this.iPartyRoleService.addPartyRoleFromInd(partyRole);
        return partyRole;
    }

    private Cust addNewCust() {
        PartyRole partyRole = addNewPartyRole();
        CustTp custTp = CustTp.builder().custTpId(TpVals.CUST_TP_PRVT).build();
        Cust cust = Cust.builder()
                .custTp(custTp)
                .partyRole(partyRole)
                .stId(StatusCode.CUST_ACTV)
                .build();
        this.iCustService.addNewCustFromInd(cust);
        return cust;
    }

    @Override
    public void deleteIndFromCust(Ind ind) {
        this.iIndRepository.save(ind);
    }

    private CustAcct addNewCustAcct() {
        Cust cust = addNewCust();
        CustAcct custAcct = CustAcct.builder()
                .cust(cust)
                .acctTpId(GnlTps.CUST_ACCT)
                .acctName(CustAcctTps.CustAcct)
                .stId(StatusCode.CUST_ACCT_ACTV)
                .descr(CustAcctTps.CustAcct)
                .build();
        this.iCustAcctService.addCustAcctFromInd(custAcct);

        CustAcct custAcct2 = custAcct;
        custAcct2.setAcctNo(custAcct.getCustAcctId().toString());
        this.iCustAcctService.addCustAcctFromInd(custAcct2);

        return custAcct2;
    }

    private void addCntcMediumGsm(Long rowId, String gsm) {
        if (gsm == null) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.CntcMedium.cntcMediumGsmNotExist));
        }
        CntcMedium cntcMediumGsm = CntcMedium.builder()
                .rowId(rowId)
                .dataTpId(TpVals.PARTY)
                .cntcData(gsm)
                .stId(StatusCode.CNTC_MEDIUM_ACTV)
                .cntcMediumTpId(TpVals.CNTC_MEDIUM_GSM)
                .build();
        this.iCntcMediumService.addCntcMediumFromInd(cntcMediumGsm);
    }

    private void addCntcMediumEmail(Long rowId, String email) {
        if (email == null) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.CntcMedium.cntcMediumEmailNotExist));
        }
        CntcMedium cntcMediumGsm = CntcMedium.builder()
                .rowId(rowId)
                .dataTpId(TpVals.PARTY)
                .cntcData(email)
                .stId(StatusCode.CNTC_MEDIUM_ACTV)
                .cntcMediumTpId(TpVals.CNTC_MEDIUM_EML)
                .build();
        this.iCntcMediumService.addCntcMediumFromInd(cntcMediumGsm);
    }

    private void addCntcMediumHomePhone(Long rowId, String homePhone) {
        if (homePhone == null) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.CntcMedium.cntcMediumHomePhoneNotExist));
        }
            CntcMedium cntcMediumGsm = CntcMedium.builder()
                    .rowId(rowId)
                    .dataTpId(TpVals.PARTY)
                    .cntcData(homePhone)
                    .stId(StatusCode.CNTC_MEDIUM_ACTV)
                    .cntcMediumTpId(TpVals.CNTC_MEDIUM_PSTN)
                    .build();
            this.iCntcMediumService.addCntcMediumFromInd(cntcMediumGsm);
    }

    private void addCntcMediumFax(Long rowId, String fax) {
        if (fax != null) {
            CntcMedium cntcMediumGsm = CntcMedium.builder()
                    .rowId(rowId)
                    .dataTpId(TpVals.PARTY)
                    .cntcData(fax)
                    .stId(StatusCode.CNTC_MEDIUM_ACTV)
                    .cntcMediumTpId(TpVals.CNTC_MEDIUM_FAX)
                    .build();
            this.iCntcMediumService.addCntcMediumFromInd(cntcMediumGsm);
        }
    }
}