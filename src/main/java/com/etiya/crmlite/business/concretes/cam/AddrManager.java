package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.IAddrService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.request.cam.addr.CreateAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.addr.DeleteAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.addr.UpdateAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.ind.CreateAddrWhenCreateIndRequest;
import com.etiya.crmlite.business.dtos.response.cam.addr.GetAddrResponse;
import com.etiya.crmlite.business.dtos.response.cam.addr.GetAllAddrResponse;
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
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.repository.abstracts.cam.IAddrRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AddrManager implements IAddrService {
    private IAddrRepository iAddrRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllAddrResponse>> getAll() {
        List<Addr> addrs = this.iAddrRepository.findAll();
        List<GetAllAddrResponse> response = addrs.stream().map(addr -> iModelMapperService.forResponse().
                map(addr, GetAllAddrResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllAddrResponse>>(response,
                iMessageSourceService.getMessage(Messages.Addr.addrListed));
    }

    @Override
    public DataResult<GetAddrResponse> getById(Long addrId) {
        Addr addr = checkIfAddrExistsById(addrId);
        GetAddrResponse response = iModelMapperService
                .forResponse().map(addr, GetAddrResponse.class);
        return new SuccessDataResult<GetAddrResponse>(response, iMessageSourceService.getMessage(Messages.Addr.addrReceived));
    }

    @Override
    public Result addAddr(CreateAddrWhenCreateIndRequest createAddrWhenCreateCustRequest, Party party) {
        Addr createAdress = Addr.builder()
                .cntryName(createAddrWhenCreateCustRequest.getCntryName())
                .cityName(createAddrWhenCreateCustRequest.getCity())
                .strtId(createAddrWhenCreateCustRequest.getStrt())
                .strtName(createAddrWhenCreateCustRequest.getStrtName())
                .addrDesc(createAddrWhenCreateCustRequest.getAddrDesc())
                .bldgName(createAddrWhenCreateCustRequest.getBldgName())
                .bldgId(createAddrWhenCreateCustRequest.getFlatNumber())
                .rowId(party.getPartyId())
                .dataTpId(TpVals.PARTY)
                .isActv(ActvSts.ACTIVE)
                .build();
        save(createAdress);
        return new SuccessResult();
    }

    @Override
    public Result addAddr(CreateAddrRequest createAddrRequest) {
        Addr addr = Addr.builder()
                .cityName(createAddrRequest.getCityName())
                .addrDesc(createAddrRequest.getAddrDesc())
                .bldgName(createAddrRequest.getBldgName())
                .strtName(createAddrRequest.getStrtName())
                .cntryName("Turkey")
                .isActv(ActvSts.ACTIVE)
                .rowId(createAddrRequest.getRowId())//party partyId
                .strtId(null)
                .bldgId(null)
                .dataTpId(9L)
                .build();
        this.iAddrRepository.save(addr);
        return new SuccessResult(iMessageSourceService.getMessage(Messages.Addr.addrAdded));
    }

    @Override
    public void save(Addr addr) {
        this.iAddrRepository.save(addr);
    }

    @Override
    public Result deleteAddr(DeleteAddrRequest deleteAddrRequest) {
        Addr addr = getAddr(deleteAddrRequest.getAddrId());
        addr.setIsActv(ActvSts.INACTIVE);
        iAddrRepository.save(addr);
        return new SuccessResult(iMessageSourceService.getMessage(Messages.Addr.addrDeleted));
    }

    private Addr getAddr(Long addrId) {
        return this.iAddrRepository.findById(addrId).orElseThrow(()
                -> new BusinessException(iMessageSourceService.getMessage(Messages.Addr.addrListed)));
    }

    @Override
    public DataResult<UpdateAddrRequest> updateAddr(UpdateAddrRequest updateAddrRequest) {
        Addr addr = getAddr(updateAddrRequest.getAddrId());
        addr.setCityName(updateAddrRequest.getCityName());
        addr.setBldgName(updateAddrRequest.getBldgName());
        addr.setStrtName(updateAddrRequest.getStrtName());
        addr.setAddrDesc(updateAddrRequest.getAddrDesc());

        Addr savedAddr = iAddrRepository.save(addr);

        UpdateAddrRequest request = iModelMapperService.forResponse().map(savedAddr, UpdateAddrRequest.class);

        return new SuccessDataResult<>(request, iMessageSourceService.getMessage(Messages.Addr.addrUpdated));
    }

    @Override
    public Result add(CreateAddrRequest createAddressRequest) {
        Addr addr = Addr.builder()
                .cityName(createAddressRequest.getCityName())
                .addrDesc(createAddressRequest.getAddrDesc())
                .bldgName(createAddressRequest.getBldgName())
                .strtName(createAddressRequest.getStrtName())
                .cntryName("Turkey") //TODO: ULKE SEÇİMİ VAR MI?
                .isActv(StatusCode.CUST_ACTV)
                .rowId(86L)//partyId
                .strtId(StatusCode.CNTC_MEDIUM_ACTV)//?
                .bldgId(3L) // buildingId donebilir.
                .dataTpId(9L)//?
                .build();
        this.iAddrRepository.save(addr);
        return new SuccessResult(iMessageSourceService.getMessage(Messages.Addr.addrListed));
    }


    private Addr checkIfAddrExistsById(Long addrId) {
        Addr currentAddr;
        try {
            currentAddr = iAddrRepository.findById(addrId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.Addr.addrNotExistWithId));
        }
        return currentAddr;
    }

    @Override
    public DataResult<Page<List<GetAllAddrResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllAddrResponse>> response =
                this.iAddrRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllAddrResponse>>>
                (response, iMessageSourceService.getMessage(Messages.Addr.addrListed));
    }

    @Override
    public Result addAddrForCustBillAcct(CreateAddrRequest createAddrRequest) {
        Addr addr = Addr.builder()
                .cityName(createAddrRequest.getCityName())
                .addrDesc(createAddrRequest.getAddrDesc())
                .bldgName(createAddrRequest.getBldgName())
                .strtName(createAddrRequest.getStrtName())
                .cntryName("Turkey") //TODO: ULKE SEÇİMİ VAR MI?
                .isActv(StatusCode.CUST_ACTV)//düzenlenecek
                .rowId(1378L)//partyId
                .strtId(StatusCode.CNTC_MEDIUM_ACTV)//?
                .bldgId(3L) // buildingId donebilir.
                .dataTpId(StatusCode.CUST_ACCT_ACTV)//düzenle
                .build();
        this.iAddrRepository.save(addr);
        return new SuccessResult(iMessageSourceService.getMessage(Messages.Addr.addrListed));//düzenlenecek
    }

    @Override
    public Result updateAddrForCustBillAcct(UpdateAddrRequest updateAddrRequest) {
        Addr addr = this.iAddrRepository.findById(updateAddrRequest.getAddrId()).orElseThrow();
        Addr addrToUpdate = Addr.builder()
                .addrId(addr.getAddrId())
                .addrDesc(updateAddrRequest.getAddrDesc())
                .cityName(updateAddrRequest.getCityName())
                .strtName(updateAddrRequest.getStrtName())
                .bldgName(updateAddrRequest.getBldgName())
                .rowId(addr.getRowId())
                .dataTpId(addr.getDataTpId())
                .strtId(addr.getStrtId())
                .bldgId(addr.getBldgId())
                .isActv(addr.getIsActv()) //TODO: isactv-strtid arası degisebilir guncellenecek.
                .build();

        addrToUpdate.setCDate(addr.getCDate());
        addrToUpdate.setCUser(addr.getCUser());

        this.iAddrRepository.save(addrToUpdate);
        return new SuccessResult(iMessageSourceService.getMessage(Messages.Addr.addrReceived));//düzenle
    }
}
