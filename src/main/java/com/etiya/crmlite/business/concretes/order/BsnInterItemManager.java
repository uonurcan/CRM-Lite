package com.etiya.crmlite.business.concretes.order;

import com.etiya.crmlite.business.abstracts.order.IBsnInterItemService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.common.gnlChar.GetAllGnlCharResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterItem.GetAllBsnInterItemResponse;
import com.etiya.crmlite.business.dtos.response.order.bsnInterItem.GetBsnInterItemResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.order.BsnInterItem;
import com.etiya.crmlite.repository.abstracts.order.IBsnInterItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BsnInterItemManager implements IBsnInterItemService {
    private IBsnInterItemRepository iBsnInterItemRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllBsnInterItemResponse>> getAll() {
        List<BsnInterItem> bsnInterItems = this.iBsnInterItemRepository.findAll();
        List<GetAllBsnInterItemResponse> response = bsnInterItems.stream().map(bsnInterItem -> iModelMapperService.forResponse().
                map(bsnInterItem, GetAllBsnInterItemResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBsnInterItemResponse>>(response,
                iMessageSourceService.getMessage(Messages.BsnInterItem.bsnInterItemListed));
    }

    @Override
    public DataResult<GetBsnInterItemResponse> getById(Long bsnInterItemId) {
        BsnInterItem bsnInterItem= checkIfBsnInterItemById(bsnInterItemId);
        GetBsnInterItemResponse response = iModelMapperService
                .forResponse().map(bsnInterItem, GetBsnInterItemResponse.class);
        return new SuccessDataResult<GetBsnInterItemResponse>(response,iMessageSourceService.getMessage(Messages.BsnInterItem.bsnInterItemReceived));
    }

    private BsnInterItem checkIfBsnInterItemById(Long bsnInterItemId) {
        BsnInterItem currentBsnInterItem;
        try {
            currentBsnInterItem = iBsnInterItemRepository.findById(bsnInterItemId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.BsnInterItem.bsnInterItemNotExistWithId));
        }
        return currentBsnInterItem;
    }

    @Override
    public DataResult<Page<List<GetAllBsnInterItemResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllBsnInterItemResponse>> response =
                this.iBsnInterItemRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllBsnInterItemResponse>>>
                (response,iMessageSourceService.getMessage(Messages.BsnInterItem.bsnInterItemListed));
    }
}
