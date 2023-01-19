package com.etiya.crmlite.business.concretes.order;

import com.etiya.crmlite.business.abstracts.order.IBsnInterStService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetAllBsnInterResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSt.GetAllBsnInterStResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSt.GetBsnInterStResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.order.BsnInterSt;
import com.etiya.crmlite.repository.abstracts.order.IBsnInterStRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BsnInterStManager implements IBsnInterStService {
    private IBsnInterStRepository iBsnInterStRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllBsnInterStResponse>> getAll() {
        List<BsnInterSt> bsnInterSts = this.iBsnInterStRepository.findAll();
        List<GetAllBsnInterStResponse> response = bsnInterSts.stream().map(bsnInterSt -> iModelMapperService.forResponse().
                map(bsnInterSt, GetAllBsnInterStResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBsnInterStResponse>>(response,
                iMessageSourceService.getMessage(Messages.BsnInterSt.bsnInterStListed));
    }

    @Override
    public DataResult<GetBsnInterStResponse> getById(Long bsnInterStId) {
        BsnInterSt bsnInterSt= checkIfBsnInterStById(bsnInterStId);
        GetBsnInterStResponse response = iModelMapperService
                .forResponse().map(bsnInterSt, GetBsnInterStResponse.class);
        return new SuccessDataResult<GetBsnInterStResponse>(response,iMessageSourceService.getMessage(Messages.BsnInterSt.bsnInterStReceived));
    }

    private BsnInterSt checkIfBsnInterStById(Long bsnInterStId) {
        BsnInterSt currentBsnInterSt;
        try {
            currentBsnInterSt = iBsnInterStRepository.findById(bsnInterStId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.BsnInterSt.bsnInterStNotExistWithId));
        }
        return currentBsnInterSt;
    }

    @Override
    public DataResult<Page<List<GetAllBsnInterStResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllBsnInterStResponse>> response =
                this.iBsnInterStRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllBsnInterStResponse>>>
                (response,iMessageSourceService.getMessage(Messages.BsnInterSt.bsnInterStListed));
    }
}
