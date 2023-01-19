package com.etiya.crmlite.business.concretes.product;

import com.etiya.crmlite.business.abstracts.product.IProdSpecSrvcSpecService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.product.prodSpec.GetAllProdSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecSrvcSpec.GetAllProdSpecSrvcSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecSrvcSpec.GetProdSpecSrvcSpecResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.product.ProdSpecSrvcSpec;
import com.etiya.crmlite.repository.abstracts.product.IProdSpecSrvcSpecRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProdSpecSrvcSpecManager implements IProdSpecSrvcSpecService {
    private IProdSpecSrvcSpecRepository iProdSpecSrvcSpecRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllProdSpecSrvcSpecResponse>> getAll() {
        List<ProdSpecSrvcSpec> prodSpecSrvcSpecs = this.iProdSpecSrvcSpecRepository.findAll();
        List<GetAllProdSpecSrvcSpecResponse> response = prodSpecSrvcSpecs.stream().map(prodSpecSrvcSpec -> iModelMapperService.forResponse().
                map(prodSpecSrvcSpec, GetAllProdSpecSrvcSpecResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllProdSpecSrvcSpecResponse>>(response,
                iMessageSourceService.getMessage(Messages.ProdSpecSrvcSpec.prodSpecSrvcSpecListed));
    }

    @Override
    public DataResult<GetProdSpecSrvcSpecResponse> getById(Long prodSpecSrvcSpecId) {
        ProdSpecSrvcSpec prodSpecSrvcSpec= checkIfProdSpecSrvcSpecExistsById(prodSpecSrvcSpecId);
        GetProdSpecSrvcSpecResponse response = iModelMapperService
                .forResponse().map(prodSpecSrvcSpec, GetProdSpecSrvcSpecResponse.class);
        return new SuccessDataResult<GetProdSpecSrvcSpecResponse>(response,iMessageSourceService.getMessage(Messages.ProdSpecSrvcSpec.prodSpecSrvcSpecNotExistWithId));
    }

    private ProdSpecSrvcSpec checkIfProdSpecSrvcSpecExistsById(Long prodSpecSrvcSpecId) {
        ProdSpecSrvcSpec currentProdSpecSrvcSpec;
        try {
            currentProdSpecSrvcSpec = iProdSpecSrvcSpecRepository.findById(prodSpecSrvcSpecId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.ProdSpecSrvcSpec.prodSpecSrvcSpecNotExistWithId));
        }
        return currentProdSpecSrvcSpec;
    }

    @Override
    public DataResult<Page<List<GetAllProdSpecSrvcSpecResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllProdSpecSrvcSpecResponse>> response =
                this.iProdSpecSrvcSpecRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllProdSpecSrvcSpecResponse>>>
                (response,iMessageSourceService.getMessage(Messages.ProdSpecSrvcSpec.prodSpecSrvcSpecListed));
    }
}
