package com.etiya.crmlite.business.concretes.order;

import com.etiya.crmlite.business.abstracts.order.ICustOrdItemService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.order.custOrdCharVal.GetAllCustOrdCharValResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdItem.GetAllCustOrdItemResponse;
import com.etiya.crmlite.business.dtos.response.order.custOrdItem.GetCustOrdItemResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.order.CustOrdItem;
import com.etiya.crmlite.repository.abstracts.order.ICustOrdItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustOrdItemManager implements ICustOrdItemService {
    private ICustOrdItemRepository iCustOrdItemRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllCustOrdItemResponse>> getAll() {
        List<CustOrdItem> custOrdItems = this.iCustOrdItemRepository.findAll();
        List<GetAllCustOrdItemResponse> response = custOrdItems.stream().map(custOrdItem -> iModelMapperService.forResponse().
                map(custOrdItem, GetAllCustOrdItemResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllCustOrdItemResponse>>(response,
                iMessageSourceService.getMessage(Messages.CustOrdItem.custOrdItemListed));
    }

    @Override
    public DataResult<GetCustOrdItemResponse> getById(Long custOrdItemId) {
        CustOrdItem custOrdItem= checkIfCustOrdItemExistsById(custOrdItemId);
        GetCustOrdItemResponse response = iModelMapperService
                .forResponse().map(custOrdItem, GetCustOrdItemResponse.class);
        return new SuccessDataResult<GetCustOrdItemResponse>(response,iMessageSourceService.getMessage(Messages.CustOrdItem.custOrdItemReceived));
    }

    private CustOrdItem checkIfCustOrdItemExistsById(Long custOrdItemId) {
        CustOrdItem currentCustOrdItem;
        try {
            currentCustOrdItem = iCustOrdItemRepository.findById( custOrdItemId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.CustOrdItem.custOrdItemNotExistWithId));
        }
        return currentCustOrdItem;
    }

    @Override
    public DataResult<Page<List<GetAllCustOrdItemResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllCustOrdItemResponse>> response =
                this.iCustOrdItemRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllCustOrdItemResponse>>>
                (response,iMessageSourceService.getMessage(Messages.CustOrdItem.custOrdItemListed));
    }
}
