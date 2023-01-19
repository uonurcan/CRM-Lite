package com.etiya.crmlite.business.concretes.product;

import com.etiya.crmlite.business.abstracts.product.IProdSpecService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.product.prod.GetAllProdResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpec.GetAllProdSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpec.GetProdSpecResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.product.ProdSpec;
import com.etiya.crmlite.repository.abstracts.product.IProdSpecRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProdSpecManager implements IProdSpecService {
    private IProdSpecRepository iProdSpecRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllProdSpecResponse>> getAll() {
        List<ProdSpec> prodSpecs = this.iProdSpecRepository.findAll();
        List<GetAllProdSpecResponse> response = prodSpecs.stream().map(prodSpec -> iModelMapperService.forResponse().
                map(prodSpec, GetAllProdSpecResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllProdSpecResponse>>(response,
                iMessageSourceService.getMessage(Messages.ProdSpec.prodSpecListed));
    }

    @Override
    public DataResult<GetProdSpecResponse> getById(Long prodSpecId) {
        ProdSpec prodSpec= checkIfProdSpecExistsById(prodSpecId);
        GetProdSpecResponse response = iModelMapperService
                .forResponse().map(prodSpec, GetProdSpecResponse.class);
        return new SuccessDataResult<GetProdSpecResponse>(response,iMessageSourceService.getMessage(Messages.ProdSpec.prodSpecReceived));
    }

    private ProdSpec checkIfProdSpecExistsById(Long prodSpecId) {
        ProdSpec currentProdSpec;
        try {
            currentProdSpec = iProdSpecRepository.findById(prodSpecId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.ProdSpec.prodSpecNotExistWithId));
        }
        return currentProdSpec;
    }

    @Override
    public DataResult<Page<List<GetAllProdSpecResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllProdSpecResponse>> response =
                this.iProdSpecRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllProdSpecResponse>>>
                (response,iMessageSourceService.getMessage(Messages.ProdSpec.prodSpecListed));
    }
}
