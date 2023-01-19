package com.etiya.crmlite.business.concretes.product;

import com.etiya.crmlite.business.abstracts.product.IProdSpecCharUseService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.product.prodSpec.GetAllProdSpecResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecCharUse.GetAllProdSpecCharUseResponse;
import com.etiya.crmlite.business.dtos.response.product.prodSpecCharUse.GetProdSpecCharUseResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.product.ProdSpecCharUse;
import com.etiya.crmlite.repository.abstracts.product.IProdSpecCharUseRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class ProdSpecCharUseManager implements IProdSpecCharUseService {
    private IProdSpecCharUseRepository iProdSpecCharUseRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllProdSpecCharUseResponse>> getAll() {
        List<ProdSpecCharUse> prodSpecCharUses = this.iProdSpecCharUseRepository.findAll();
        List<GetAllProdSpecCharUseResponse> response = prodSpecCharUses.stream().map(prodSpecCharUse -> iModelMapperService.forResponse().
                map(prodSpecCharUse, GetAllProdSpecCharUseResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllProdSpecCharUseResponse>>(response,
                iMessageSourceService.getMessage(Messages.ProdSpecCharUse.prodSpecCharUseListed));
    }

    @Override
    public DataResult<GetProdSpecCharUseResponse> getById(Long prodSpecCharUseId) {
        ProdSpecCharUse prodSpecCharUse= checkIfProdSpecCharUseExistsById(prodSpecCharUseId);
        GetProdSpecCharUseResponse response = iModelMapperService
                .forResponse().map(prodSpecCharUse, GetProdSpecCharUseResponse.class);
        return new SuccessDataResult<GetProdSpecCharUseResponse>(response,iMessageSourceService.getMessage(Messages.ProdSpecCharUse.prodSpecCharUseReceived));
    }

    private ProdSpecCharUse checkIfProdSpecCharUseExistsById(Long prodSpecCharUseId) {
        ProdSpecCharUse currentProdSpecCharUse;
        try {
            currentProdSpecCharUse = iProdSpecCharUseRepository.findById(prodSpecCharUseId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.ProdSpecCharUse.prodSpecCharUseNotExistWithId));
        }
        return currentProdSpecCharUse;
    }

    @Override
    public DataResult<Page<List<GetAllProdSpecCharUseResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllProdSpecCharUseResponse>> response =
                this.iProdSpecCharUseRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllProdSpecCharUseResponse>>>
                (response,iMessageSourceService.getMessage(Messages.ProdSpecCharUse.prodSpecCharUseListed));
    }
}
