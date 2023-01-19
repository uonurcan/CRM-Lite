package com.etiya.crmlite.business.concretes.order;

import com.etiya.crmlite.business.abstracts.order.IBsnInterSpecService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetAllBsnInterResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSpec.GetAllBsnInterSpecResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterSpec.GetBsnInterSpecResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.order.BsnInterSpec;
import com.etiya.crmlite.repository.abstracts.order.IBsnInterSpecRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BsnInterSpecManager implements IBsnInterSpecService {
    private IBsnInterSpecRepository iBsnInterSpecRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllBsnInterSpecResponse>> getAll() {
        List<BsnInterSpec> bsnInterSpecs = this.iBsnInterSpecRepository.findAll();
        List<GetAllBsnInterSpecResponse> response = bsnInterSpecs.stream().map(bsnInterSpec -> iModelMapperService.forResponse().
                map(bsnInterSpec, GetAllBsnInterSpecResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBsnInterSpecResponse>>(response,
                iMessageSourceService.getMessage(Messages.BsnInterSpec.bsnInterSpecListed));
    }

    @Override
    public DataResult<GetBsnInterSpecResponse> getById(Long bsnInterSpecId) {
        BsnInterSpec bsnInterSpec= checkIfBsnInterSpecById(bsnInterSpecId);
        GetBsnInterSpecResponse response = iModelMapperService
                .forResponse().map(bsnInterSpec, GetBsnInterSpecResponse.class);
        return new SuccessDataResult<GetBsnInterSpecResponse>(response,iMessageSourceService.getMessage(Messages.BsnInterSpec.bsnInterSpecReceived));
    }

    private BsnInterSpec checkIfBsnInterSpecById(Long bsnInterSpecId) {
        BsnInterSpec currentBsnInterSpec;
        try {
            currentBsnInterSpec = iBsnInterSpecRepository.findById(bsnInterSpecId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.BsnInterSpec.bsnInterSpecNotExistWithId));
        }
        return currentBsnInterSpec;
    }

    @Override
    public DataResult<Page<List<GetAllBsnInterSpecResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllBsnInterSpecResponse>> response =
                this.iBsnInterSpecRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllBsnInterSpecResponse>>>
                (response,iMessageSourceService.getMessage(Messages.BsnInterSpec.bsnInterSpecListed));
    }
}
