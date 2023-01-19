package com.etiya.crmlite.business.concretes.product;

import com.etiya.crmlite.business.abstracts.product.IProdCharValService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.product.prodCatalProdOfr.GetAllProdCatalProdOfrResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCharVal.GetAllProdCharValResponse;
import com.etiya.crmlite.business.dtos.response.product.prodCharVal.GetProdCharValResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.product.ProdCharVal;
import com.etiya.crmlite.repository.abstracts.product.IProdCharValRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProdCharValManager implements IProdCharValService {
    private IProdCharValRepository iProdCharValRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllProdCharValResponse>> getAll() {
        List<ProdCharVal> prodCharVals = this.iProdCharValRepository.findAll();
        List<GetAllProdCharValResponse> response = prodCharVals.stream().map(prodCharVal -> iModelMapperService.forResponse().
                map(prodCharVal, GetAllProdCharValResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllProdCharValResponse>>(response,
                iMessageSourceService.getMessage(Messages.ProdCharVal.prodCharValListed));
    }

    @Override
    public DataResult<GetProdCharValResponse> getById(Long prodCharValId) {
        ProdCharVal prodCharVal= checkIfProdCharValExistsById(prodCharValId);
        GetProdCharValResponse response = iModelMapperService
                .forResponse().map(prodCharVal, GetProdCharValResponse.class);
        return new SuccessDataResult<GetProdCharValResponse>(response,iMessageSourceService.getMessage(Messages.ProdCharVal.prodCharValReceived));
    }

    private ProdCharVal checkIfProdCharValExistsById(Long prodCharValId) {
        ProdCharVal currentProdCharVal;
        try {
            currentProdCharVal = iProdCharValRepository.findById(prodCharValId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.ProdCharVal.prodCharValNotExistWithId));
        }
        return currentProdCharVal;
    }

    @Override
    public DataResult<Page<List<GetAllProdCharValResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllProdCharValResponse>> response =
                this.iProdCharValRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllProdCharValResponse>>>
                (response,iMessageSourceService.getMessage(Messages.ProdCharVal.prodCharValListed));
    }
}
