package com.etiya.crmlite.business.concretes.product;

import com.etiya.crmlite.business.abstracts.product.IProdRelService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.product.prod.GetAllProdResponse;
import com.etiya.crmlite.business.dtos.response.product.prodRel.GetAllProdRelResponse;
import com.etiya.crmlite.business.dtos.response.product.prodRel.GetProdRelResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.product.ProdRel;
import com.etiya.crmlite.repository.abstracts.product.IProdRelRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProdRelManager implements IProdRelService {
    private IProdRelRepository iProdRelRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllProdRelResponse>> getAll() {
        List<ProdRel> prodRels = this.iProdRelRepository.findAll();
        List<GetAllProdRelResponse> response = prodRels.stream().map(prodRel -> iModelMapperService.forResponse().
                map(prodRel, GetAllProdRelResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllProdRelResponse>>(response,
                iMessageSourceService.getMessage(Messages.ProdRel.prodRelListed));
    }

    @Override
    public DataResult<GetProdRelResponse> getById(Long prodRelId) {
        ProdRel prodRel= checkIfProdRelExistsById(prodRelId);
        GetProdRelResponse response = iModelMapperService
                .forResponse().map(prodRel, GetProdRelResponse.class);
        return new SuccessDataResult<GetProdRelResponse>(response,iMessageSourceService.getMessage(Messages.ProdRel.prodRelReceived));
    }

    private ProdRel checkIfProdRelExistsById(Long prodRelId) {
        ProdRel currentProdRel;
        try {
            currentProdRel = iProdRelRepository.findById(prodRelId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.ProdRel.prodRelListedNotExistWithId));
        }
        return currentProdRel;
    }

    @Override
    public DataResult<Page<List<GetAllProdRelResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllProdRelResponse>> response =
                this.iProdRelRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllProdRelResponse>>>
                (response,iMessageSourceService.getMessage(Messages.ProdRel.prodRelListed));
    }
}
