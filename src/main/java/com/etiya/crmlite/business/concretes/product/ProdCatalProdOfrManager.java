package com.etiya.crmlite.business.concretes.product;

import com.etiya.crmlite.business.abstracts.product.IProdCatalProdOfrService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.product.prodCatal.GetAllProdCatalResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr.GetAllProdCatalProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr.GetProdCatalProdOfrResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.product.ProdCatalProdOfr;
import com.etiya.crmlite.repository.abstracts.product.IProdCatalProdOfrRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProdCatalProdOfrManager implements IProdCatalProdOfrService {
    private IProdCatalProdOfrRepository iProdCatalProdOfrRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllProdCatalProdOfrResponse>> getAll() {
        List<ProdCatalProdOfr> prodCatalProdOfrs = this.iProdCatalProdOfrRepository.findAll();
        List<GetAllProdCatalProdOfrResponse> response = prodCatalProdOfrs.stream().map(prodCatalProdOfr -> iModelMapperService.forResponse().
                map(prodCatalProdOfr, GetAllProdCatalProdOfrResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllProdCatalProdOfrResponse>>(response,
                iMessageSourceService.getMessage(Messages.ProdCatalProdOfr.prodCatalProdOfrListed));
    }

    @Override
    public DataResult<GetProdCatalProdOfrResponse> getById(Long prodCatalProdOfrId) {
        ProdCatalProdOfr prodCatalProdOfr= checkIfProdCatalProdOfrExistsById(prodCatalProdOfrId);
        GetProdCatalProdOfrResponse response = iModelMapperService
                .forResponse().map(prodCatalProdOfr, GetProdCatalProdOfrResponse.class);
        return new SuccessDataResult<GetProdCatalProdOfrResponse>(response,iMessageSourceService.getMessage(Messages.ProdCatalProdOfr.prodCatalProdOfrReceived));
    }

    private ProdCatalProdOfr checkIfProdCatalProdOfrExistsById(Long prodCatalProdOfrId) {
        ProdCatalProdOfr currentProdCatalProdOfr;
        try {
            currentProdCatalProdOfr = iProdCatalProdOfrRepository.findById(prodCatalProdOfrId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.ProdCatalProdOfr.ProdCatalProdOfrNotExistWithId));
        }
        return currentProdCatalProdOfr;
    }

    @Override
    public DataResult<Page<List<GetAllProdCatalProdOfrResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllProdCatalProdOfrResponse>> response =
                this.iProdCatalProdOfrRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllProdCatalProdOfrResponse>>>
                (response,iMessageSourceService.getMessage(Messages.ProdCatalProdOfr.prodCatalProdOfrListed));
    }
}
