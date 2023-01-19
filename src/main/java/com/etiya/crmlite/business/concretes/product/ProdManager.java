package com.etiya.crmlite.business.concretes.product;

import com.etiya.crmlite.business.abstracts.product.IProdService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.order.custOrdCharVal.GetAllCustOrdCharValResponse;
import com.etiya.crmlite.business.dtos.response.product.prod.GetAllProdResponse;
import com.etiya.crmlite.business.dtos.response.product.prod.GetProdResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.product.Prod;
import com.etiya.crmlite.repository.abstracts.product.IProdRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProdManager implements IProdService {
    private IProdRepository iProdRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllProdResponse>> getAll() {
        List<Prod> prods = this.iProdRepository.findAll();
        List<GetAllProdResponse> response = prods.stream().map(prod -> iModelMapperService.forResponse().
                map(prod, GetAllProdResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllProdResponse>>(response,
                iMessageSourceService.getMessage(Messages.Prod.prodListed));
    }

    @Override
    public DataResult<GetProdResponse> getById(Long prodId) {
        Prod prod= checkIfProdExistsById(prodId);
        GetProdResponse response = iModelMapperService
                .forResponse().map(prod, GetProdResponse.class);
        return new SuccessDataResult<GetProdResponse>(response,iMessageSourceService.getMessage(Messages.Prod.prodReceived));
    }

    private Prod checkIfProdExistsById(Long prodId) {
        Prod currentProd;
        try {
            currentProd = iProdRepository.findById(prodId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.Prod.prodNotExistWithId));
        }
        return currentProd;
    }

    @Override
    public DataResult<Page<List<GetAllProdResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllProdResponse>> response =
                this.iProdRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllProdResponse>>>
                (response,iMessageSourceService.getMessage(Messages.Prod.prodListed));
    }
}
