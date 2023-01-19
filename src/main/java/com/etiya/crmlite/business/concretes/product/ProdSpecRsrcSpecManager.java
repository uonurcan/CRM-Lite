package com.etiya.crmlite.business.concretes.product;

import com.etiya.crmlite.business.abstracts.product.IProdSpecRsrcSpecService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.product.prodSpec.GetAllProdSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecRsrcSpec.GetAllProdSpecRsrcSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecRsrcSpec.GetProdSpecRsrcSpecResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.product.ProdSpecRsrcSpec;
import com.etiya.crmlite.repository.abstracts.product.IProdSpecRsrcSpecRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProdSpecRsrcSpecManager implements IProdSpecRsrcSpecService {
    private IProdSpecRsrcSpecRepository iProdSpecRsrcSpecRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllProdSpecRsrcSpecResponse>> getAll() {
        List<ProdSpecRsrcSpec> prodSpecRsrcSpecs = this.iProdSpecRsrcSpecRepository.findAll();
        List<GetAllProdSpecRsrcSpecResponse> response = prodSpecRsrcSpecs.stream().map(prodSpecRsrcSpec -> iModelMapperService.forResponse().
                map(prodSpecRsrcSpec, GetAllProdSpecRsrcSpecResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllProdSpecRsrcSpecResponse>>(response,
                iMessageSourceService.getMessage(Messages.ProdSpecRsrcSpec.prodSpecRsrcSpecListed));
    }

    @Override
    public DataResult<GetProdSpecRsrcSpecResponse> getById(Long prodSpecRsrcSpecId) {
        ProdSpecRsrcSpec prodSpecRsrcSpec= checkIfProdSpecRsrcSpecExistsById(prodSpecRsrcSpecId);
        GetProdSpecRsrcSpecResponse response = iModelMapperService
                .forResponse().map(prodSpecRsrcSpec, GetProdSpecRsrcSpecResponse.class);
        return new SuccessDataResult<GetProdSpecRsrcSpecResponse>(response,iMessageSourceService.getMessage(Messages.ProdSpecRsrcSpec.prodSpecRsrcSpecReceived));
    }

    private ProdSpecRsrcSpec checkIfProdSpecRsrcSpecExistsById(Long prodSpecRsrcSpecId) {
        ProdSpecRsrcSpec currentProdSpecRsrcSpec;
        try {
            currentProdSpecRsrcSpec = iProdSpecRsrcSpecRepository.findById(prodSpecRsrcSpecId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.ProdSpecRsrcSpec.prodSpecRsrcSpecNotExistWithId));
        }
        return currentProdSpecRsrcSpec;
    }

    @Override
    public DataResult<Page<List<GetAllProdSpecRsrcSpecResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllProdSpecRsrcSpecResponse>> response =
                this.iProdSpecRsrcSpecRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllProdSpecRsrcSpecResponse>>>
                (response,iMessageSourceService.getMessage(Messages.ProdSpecRsrcSpec.prodSpecRsrcSpecListed));
    }
}
