package com.etiya.crmlite.business.concretes.product;

import com.etiya.crmlite.business.abstracts.product.IProdOfrService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.product.prod.GetAllProdResponse;
import com.etiya.crmlite.business.dtos.response.product.prodOfr.GetAllProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.prodOfr.GetProdOfrResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.product.ProdOfr;
import com.etiya.crmlite.repository.abstracts.product.IProdOfrRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProdOfrManager implements IProdOfrService {
    private IProdOfrRepository iProdOfrRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllProdOfrResponse>> getAll() {
        List<ProdOfr> prodOfrs = this.iProdOfrRepository.findAll();
        List<GetAllProdOfrResponse> response = prodOfrs.stream().map(prodOfr -> iModelMapperService.forResponse().
                map(prodOfr, GetAllProdOfrResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllProdOfrResponse>>(response,
                iMessageSourceService.getMessage(Messages.ProdOfr.prodOfrListed));
    }

    @Override
    public DataResult<GetProdOfrResponse> getById(Long prodOfrId) {
        ProdOfr prodOfr= checkIfProdOfrExistsById(prodOfrId);
        GetProdOfrResponse response = iModelMapperService
                .forResponse().map(prodOfr, GetProdOfrResponse.class);
        return new SuccessDataResult<GetProdOfrResponse>(response,iMessageSourceService.getMessage(Messages.ProdOfr.prodOfrReceived));
    }

    private ProdOfr checkIfProdOfrExistsById(Long prodOfrId) {
        ProdOfr currentProdOfr;
        try {
            currentProdOfr = iProdOfrRepository.findById(prodOfrId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.ProdOfr.prodOfrNotExistWithId));
        }
        return currentProdOfr;
    }

    @Override
    public DataResult<Page<List<GetAllProdOfrResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllProdOfrResponse>> response =
                this.iProdOfrRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllProdOfrResponse>>>
                (response,iMessageSourceService.getMessage(Messages.ProdOfr.prodOfrListed));
    }
}
