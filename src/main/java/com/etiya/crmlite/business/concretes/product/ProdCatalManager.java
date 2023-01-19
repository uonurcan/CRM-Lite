package com.etiya.crmlite.business.concretes.product;

import com.etiya.crmlite.business.abstracts.product.IProdCatalService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.product.cmpgProdOfr.GetAllCmpgProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCatal.GetAllProdCatalResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCatal.GetProdCatalResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.product.ProdCatal;
import com.etiya.crmlite.repository.abstracts.product.IProdCatalRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProdCatalManager implements IProdCatalService {
    private IProdCatalRepository iProdCatalRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllProdCatalResponse>> getAll() {
        List<ProdCatal> prodCatals = this.iProdCatalRepository.findAll();
        List<GetAllProdCatalResponse> response = prodCatals.stream().map(prodCatal -> iModelMapperService.forResponse().
                map(prodCatal, GetAllProdCatalResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllProdCatalResponse>>(response,
                iMessageSourceService.getMessage(Messages.ProdCatal.prodCatalListed));
    }

    @Override
    public DataResult<GetProdCatalResponse> getById(Long prodCatalId) {
        ProdCatal prodCatal= checkIfProdCatalExistsById(prodCatalId);
        GetProdCatalResponse response = iModelMapperService
                .forResponse().map(prodCatal, GetProdCatalResponse.class);
        return new SuccessDataResult<GetProdCatalResponse>(response,iMessageSourceService.getMessage(Messages.ProdCatal.prodCatalReceived));
    }

    private ProdCatal checkIfProdCatalExistsById(Long prodCatalId) {
        ProdCatal currentProdCatal;
        try {
            currentProdCatal = iProdCatalRepository.findById(prodCatalId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.ProdCatal.prodCatalNotExistWithId));
        }
        return currentProdCatal;
    }
    @Override
    public DataResult<Page<List<GetAllProdCatalResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllProdCatalResponse>> response =
                this.iProdCatalRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllProdCatalResponse>>>
                (response,iMessageSourceService.getMessage(Messages.ProdCatal.prodCatalListed));
    }
}
