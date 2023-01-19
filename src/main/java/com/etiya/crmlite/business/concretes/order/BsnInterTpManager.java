package com.etiya.crmlite.business.concretes.order;

import com.etiya.crmlite.business.abstracts.order.IBsnInterTpService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.order.bsnInter.GetAllBsnInterResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterTp.GetAllBsnInterTpResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterTp.GetBsnInterTpResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.order.BsnInterTp;
import com.etiya.crmlite.repository.abstracts.order.IBsnInterTpRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BsnInterTpManager implements IBsnInterTpService {
    private IBsnInterTpRepository iBsnInterTpRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllBsnInterTpResponse>> getAll() {
        List<BsnInterTp> bsnInterTps = this.iBsnInterTpRepository.findAll();
        List<GetAllBsnInterTpResponse> response = bsnInterTps.stream().map(bsnInterTp -> iModelMapperService.forResponse().
                map(bsnInterTp, GetAllBsnInterTpResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBsnInterTpResponse>>(response,
                iMessageSourceService.getMessage(Messages.BsnInterTp.bsnInterTpListed));
    }

    @Override
    public DataResult<GetBsnInterTpResponse> getById(Long bsnInterTpId) {
        BsnInterTp bsnInterTp= checkIfBsnInterTpById(bsnInterTpId);
        GetBsnInterTpResponse response = iModelMapperService
                .forResponse().map(bsnInterTp, GetBsnInterTpResponse.class);
        return new SuccessDataResult<GetBsnInterTpResponse>(response,iMessageSourceService.getMessage(Messages.BsnInterTp.bsnInterTpReceived));
    }

    private BsnInterTp checkIfBsnInterTpById(Long bsnInterTpId) {
        BsnInterTp currentBsnInterTp;
        try {
            currentBsnInterTp = iBsnInterTpRepository.findById(bsnInterTpId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.BsnInterTp.bsnInterTpNotExistWithId));
        }
        return currentBsnInterTp;
    }

    @Override
    public DataResult<Page<List<GetAllBsnInterTpResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllBsnInterTpResponse>> response =
                this.iBsnInterTpRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllBsnInterTpResponse>>>
                (response,iMessageSourceService.getMessage(Messages.BsnInterTp.bsnInterTpListed));
    }
}
