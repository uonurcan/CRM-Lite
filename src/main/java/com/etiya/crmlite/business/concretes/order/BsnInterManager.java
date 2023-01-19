package com.etiya.crmlite.business.concretes.order;

import com.etiya.crmlite.business.abstracts.order.IBsnInterService;
import com.etiya.crmlite.business.abstracts.order.ICustOrdService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.request.order.custOrd.SaveCustOrdRequest;
import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetAllBsnInterResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetBsnInterResponse;
import com.etiya.crmlite.core.utilities.enums.StatusCode;
import com.etiya.crmlite.core.utilities.enums.TpVals;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.core.utilities.results.SuccessResult;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.entities.concretes.order.*;
import com.etiya.crmlite.repository.abstracts.order.IBsnInterRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.spel.ast.TypeCode;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BsnInterManager implements IBsnInterService {
    private IBsnInterRepository iBsnInterRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;
    private ICustOrdService iCustOrdService;

    @Override
    public DataResult<List<GetAllBsnInterResponse>> getAll() {
        List<BsnInter> bsnInters = this.iBsnInterRepository.findAll();
        List<GetAllBsnInterResponse> response = bsnInters.stream().map(bsnInter -> iModelMapperService.forResponse().
                map(bsnInter, GetAllBsnInterResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBsnInterResponse>>(response,
                iMessageSourceService.getMessage(Messages.BsnInterItem.bsnInterItemListed));
    }

    @Override
    public DataResult<GetBsnInterResponse> getById(Long bsnInterId) {
        BsnInter bsnInter= checkIfBsnInterById(bsnInterId);
        GetBsnInterResponse response = iModelMapperService
                .forResponse().map(bsnInter, GetBsnInterResponse.class);
        return new SuccessDataResult<GetBsnInterResponse>(response,iMessageSourceService.getMessage(Messages.BsnInter.bsnInterReceived));
    }

    private BsnInter checkIfBsnInterById(Long bsnInterId) {
        BsnInter currentBsnInter;
        try {
            currentBsnInter = iBsnInterRepository.findById(bsnInterId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.BsnInter.bsnInterNotExistWithId));
        }
        return currentBsnInter;
    }

    @Override
    public DataResult<Page<List<GetAllBsnInterResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllBsnInterResponse>> response =
                this.iBsnInterRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllBsnInterResponse>>>
                (response,iMessageSourceService.getMessage(Messages.BsnInter.bsnInterListed));
    }

    @Transactional
    @Override
    public Result startNewSale(Long custId){
        Party party = iBsnInterRepository.findPartyByCustId(custId);

        BsnInter bsnInter = BsnInter.builder()
                .bsnInterSpec(BsnInterSpec.builder()
                        .bsnInterSpecId(TpVals.BSN_INTER_SPEC_SALE)
                        .bsnInterTp(BsnInterTp.builder()
                                .bsnInterTpId(TpVals.BSN_INTER_TP_ORDER).build())// düzelt
                        .build())
                .custId(custId)
                .rowId(party.getPartyId())
                .descr("Yeni Satış")
                .dataTpId(TpVals.BSN_INTER_SPEC_SALE)//düzelt
                .bsnInterSt(BsnInterSt.builder()
                        .bsnInterStId(StatusCode.BSN_INTER_ST_WAIT)
                        .build())
                //prnt
                .build();

        BsnInter savedBsnInter = iBsnInterRepository.save(bsnInter);

        CustOrd custOrd = CustOrd.builder()
                .bsnInterSpecId(TpVals.BSN_INTER_SPEC_SALE)
                .custId(custId)
                .ordStId(StatusCode.CUST_ORD_WAIT)
                .bsnInterId(savedBsnInter.getBsnInterId())
                .build();
        SaveCustOrdRequest saveCustOrdRequest = SaveCustOrdRequest.builder()
                .bsnInterSpecId(custOrd.getBsnInterSpecId())
                .custId(custOrd.getCustId())
                .bsnInterId(custOrd.getBsnInterId())
                .OrdStId(custOrd.getOrdStId())
                .build();
        iCustOrdService.save(saveCustOrdRequest);

        return new SuccessResult(iMessageSourceService.getMessage(Messages.BsnInter.bsnInterListed));

    }
}
