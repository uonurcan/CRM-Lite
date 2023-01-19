package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.ICntcMediumService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.request.cam.cntcMedium.CreateCntcMediumRequest;
import com.etiya.crmlite.business.dtos.request.cam.cntcMedium.DeleteCntcMediumRequest;
import com.etiya.crmlite.business.dtos.request.cam.cntcMedium.UpdateCntcMediumRequest;
import com.etiya.crmlite.business.dtos.response.cam.cntcMedium.GetAllCntcMediumResponse;
import com.etiya.crmlite.business.dtos.response.cam.cntcMedium.GetCntcMediumResponse;
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
import com.etiya.crmlite.entities.concretes.cam.CntcMedium;
import com.etiya.crmlite.repository.abstracts.cam.ICntcMediumRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CntcMediumManager implements ICntcMediumService {
    private ICntcMediumRepository iCntcMediumRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllCntcMediumResponse>> getAll() {

        List<CntcMedium> cntcMediums = this.iCntcMediumRepository.findAll();
        List<GetAllCntcMediumResponse> response = cntcMediums.stream().map(cntcMedium -> iModelMapperService.forResponse().
                map(cntcMedium, GetAllCntcMediumResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllCntcMediumResponse>>(response,
                iMessageSourceService.getMessage(Messages.CntcMedium.cntcMediumListed));
    }

    @Override
    public DataResult<GetCntcMediumResponse> getById(Long cntcMediumId) {
        CntcMedium cntcMedium = checkIfCntcMediumExistsById(cntcMediumId);
        GetCntcMediumResponse response = iModelMapperService
                .forResponse().map(cntcMedium, GetCntcMediumResponse.class);
        return new SuccessDataResult<GetCntcMediumResponse>(response, iMessageSourceService.getMessage(Messages.CntcMedium.cntcMediumReceived));
    }

    @Override
    public Result add(CreateCntcMediumRequest createCntcMediumRequest) {
        CntcMedium cntcMedium = CntcMedium.builder()
                .stId(StatusCode.CNTC_MEDIUM_ACTV)
                .cntcMediumTpId(createCntcMediumRequest.getCntcMediumTpId())
                .cntcData(createCntcMediumRequest.getCntcData())
                .rowId(createCntcMediumRequest.getRowId())
                .dataTpId(TpVals.PARTY)
                .build();
        this.iCntcMediumRepository.save(cntcMedium);
        return new SuccessResult(iMessageSourceService.getMessage(Messages.CntcMedium.cntcMediumAdded));
    }

    @Override
    public Result delete(DeleteCntcMediumRequest deleteCntcMediumRequest) {
        CntcMedium cntcMedium = getCntcMedium(deleteCntcMediumRequest.getCntcMediumId());
        cntcMedium.setStId(111L);
        iCntcMediumRepository.save(cntcMedium);
        return new SuccessResult(iMessageSourceService.getMessage(Messages.CntcMedium.cntcMediumListed));
    }

    @Override
    public void addCntcMediumFromInd(CntcMedium cntcMedium) {
        this.iCntcMediumRepository.save(cntcMedium);
    }

    private CntcMedium getCntcMedium(Long cntcMediumId) {
        return this.iCntcMediumRepository.findById(cntcMediumId).orElseThrow(()
                -> new BusinessException(iMessageSourceService.getMessage(Messages.CntcMedium.cntcMediumNotExistWithId)));
    }

    @Override
    public Result update(UpdateCntcMediumRequest updateCntcMediumRequest) {
        CntcMedium cntcMedium = CntcMedium.builder()
                .cntcMediumId(updateCntcMediumRequest.getCntcMediumId())
                .stId(updateCntcMediumRequest.getStId())
                .cntcMediumTpId(updateCntcMediumRequest.getCntcMediumTpId())
                .cntcData(updateCntcMediumRequest.getCntcData())
                .rowId(updateCntcMediumRequest.getRowId())
                .dataTpId(updateCntcMediumRequest.getDataTpId())
                .build();
        this.iCntcMediumRepository.save(cntcMedium);
        return new SuccessResult(iMessageSourceService.getMessage(Messages.CntcMedium.cntcMediumListed));
    }

    private CntcMedium checkIfCntcMediumExistsById(Long cntcMediumId) {
        CntcMedium currentCntcMedium;
        try {
            currentCntcMedium = iCntcMediumRepository.findById(cntcMediumId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.CntcMedium.cntcMediumNotExistWithId));
        }
        return currentCntcMedium;
    }

    @Override
    public DataResult<Page<List<GetAllCntcMediumResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllCntcMediumResponse>> response =
                this.iCntcMediumRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllCntcMediumResponse>>>
                (response, iMessageSourceService.getMessage(Messages.CntcMedium.cntcMediumListed));
    }
}
