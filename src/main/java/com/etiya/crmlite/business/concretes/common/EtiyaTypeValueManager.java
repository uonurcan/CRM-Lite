package com.etiya.crmlite.business.concretes.common;

import com.etiya.crmlite.business.abstracts.common.IEtiyaTypeValueService;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.response.cam.partyRole.GetAllPartyRoleResponse;
import com.etiya.crmlite.business.dtos.response.common.etiyaTypeValue.GetAllEtiyaTypeValueResponse;
import com.etiya.crmlite.business.dtos.response.common.etiyaTypeValue.GetEtiyaTypeValueResponse;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.common.EtiyaTypeValue;
import com.etiya.crmlite.repository.abstracts.common.IEtiyaTypeValueRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EtiyaTypeValueManager implements IEtiyaTypeValueService {
    private IEtiyaTypeValueRepository iEtiyaTypeValueRepository;
    private IModelMapperService iModelMapperService;
    private IMessageSourceService iMessageSourceService;

    @Override
    public DataResult<List<GetAllEtiyaTypeValueResponse>> getAll() {
        List<EtiyaTypeValue> etiyaTypeValues = this.iEtiyaTypeValueRepository.findAll();
        List<GetAllEtiyaTypeValueResponse> response = etiyaTypeValues.stream().map(etiyaTypeValue -> iModelMapperService.forResponse().
                map(etiyaTypeValue, GetAllEtiyaTypeValueResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllEtiyaTypeValueResponse>>(response,
                iMessageSourceService.getMessage(Messages.EtiyaTypeValue.etiyaTypeValueListed));
    }

    @Override
    public DataResult<GetEtiyaTypeValueResponse> getById(Long etiyaTypeValueId) {
        EtiyaTypeValue etiyaTypeValue= checkIfEtiyaTypeValueExistsById(etiyaTypeValueId);
        GetEtiyaTypeValueResponse response = iModelMapperService
                .forResponse().map(etiyaTypeValue, GetEtiyaTypeValueResponse.class);
        return new SuccessDataResult<GetEtiyaTypeValueResponse>(response,iMessageSourceService.getMessage(Messages.EtiyaTypeValue.etiyaTypeValueReceived));
    }

    private EtiyaTypeValue checkIfEtiyaTypeValueExistsById(Long etiyaTypeValueId) {
        EtiyaTypeValue currentEtiyaTypeValue;
        try {
            currentEtiyaTypeValue = iEtiyaTypeValueRepository.findById(etiyaTypeValueId).get();
        } catch (Exception e) {
            throw new BusinessException(iMessageSourceService.getMessage(Messages.EtiyaTypeValue.etiyaTypeValueNotExistWithId));
        }
        return currentEtiyaTypeValue;
    }

    @Override
    public DataResult<Page<List<GetAllEtiyaTypeValueResponse>>> getAllWithPagination(Pageable pageable) {
        Page<List<GetAllEtiyaTypeValueResponse>> response =
                this.iEtiyaTypeValueRepository.getAllWithPagination(pageable);
        return new SuccessDataResult<Page<List<GetAllEtiyaTypeValueResponse>>>
                (response,iMessageSourceService.getMessage(Messages.EtiyaTypeValue.etiyaTypeValueListed));
    }
}
