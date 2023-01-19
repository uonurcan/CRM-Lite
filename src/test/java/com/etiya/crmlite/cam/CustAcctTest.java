/*
package com.etiya.crmlite.cam;

import com.etiya.crmlite.business.abstracts.cam.IAddrService;
import com.etiya.crmlite.business.abstracts.cam.ICustAcctProdInvlService;
import com.etiya.crmlite.business.abstracts.cam.ICustService;
import com.etiya.crmlite.business.concretes.cam.CustAcctManager;
import com.etiya.crmlite.business.dtos.response.cam.custAcct.GetAllCustAcctResponse;
import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.mapping.ModelMapperManager;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.messages.MessageSourceManager;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.entities.concretes.cam.CustAcct;
import com.etiya.crmlite.repository.abstracts.cam.ICustAcctRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustAcctTest {

    CustAcctManager custAcctManager;
    ICustAcctRepository iCustAcctRepository;
    IModelMapperService iModelMapperService;
    MessageSource messageSource;
    IMessageSourceService iMessageSourceService;
    ICustService iCustService;
    IAddrService iAddrService;
    ICustAcctProdInvlService iCustAcctProdInvlService;

    @BeforeEach
    void setUp() {
        iCustAcctRepository= mock(ICustAcctRepository.class);
        iModelMapperService = new ModelMapperManager(new ModelMapper());
        messageSource = new ResourceBundleMessageSource();
        iMessageSourceService = new MessageSourceManager(messageSource);
        custAcctManager = new CustAcctManager(iCustAcctRepository,iModelMapperService,iMessageSourceService,iCustService,iAddrService,iCustAcctProdInvlService);

    }

    @Test
    void getAll() {

        List<CustAcct> custAcctListToReturn = new ArrayList<>();
        custAcctListToReturn.add(CustAcct.builder().custAcctId(1L).cust().acctNo().acctName().acctTpId().custAcctProdInvl().stId().descr().build());


        when(iCustAcctRepository.findAll()).thenReturn(custAcctListToReturn);
       DataResult<List<GetAllCustAcctResponse>>actualResult = custAcctManager.getAll();
        assert custAcctListToReturn.size() == actualResult.size();

    }

    @Test
    void getById() {
        Category categoryToReturn = Category.builder().name("Kategori 1").id(1).type("Giyim").build();
        Optional<Category> category = Optional.of(categoryToReturn);
        when(categoryRepository.findById(1)).thenReturn(category);

        Category actualCategory = categoryManager.getById(1);
        assert actualCategory.equals(categoryToReturn);
    }

    @Test
    void getById_NotExist_ShouldThrowException(){
        // exception fırlatma testi..
        assertThrows(BusinessException.class, () -> {
            categoryManager.getById(2);
        });
    }
}
*/
