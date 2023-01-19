package com.etiya.crmlite.cam;


import com.etiya.crmlite.business.concretes.cam.AddrManager;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.request.cam.addr.CreateAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.addr.DeleteAddrRequest;
import com.etiya.crmlite.business.dtos.request.cam.addr.UpdateAddrRequest;

import com.etiya.crmlite.business.dtos.response.cam.addr.GetAddrResponse;
import com.etiya.crmlite.business.dtos.response.cam.addr.GetAllAddrResponse;

import com.etiya.crmlite.core.utilities.mapping.IModelMapperService;
import com.etiya.crmlite.core.utilities.mapping.ModelMapperManager;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.cam.Addr;
import com.etiya.crmlite.repository.abstracts.cam.IAddrRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;


class AddrTest {

    private AddrManager addrManager;
    // MOCK


    private IMessageSourceService iMessageSourceService;
    private MessageSource messageSource;
    private IAddrRepository iAddrRepository;
    private IModelMapperService iModelMapperService;

    @BeforeEach
    void setUp() {
        iAddrRepository = mock(IAddrRepository.class);
        messageSource = getResourceBundle();
        iMessageSourceService = mock(IMessageSourceService.class);
        iModelMapperService = new ModelMapperManager(new ModelMapper());
        addrManager = new AddrManager(iAddrRepository, iModelMapperService, iMessageSourceService);
    }

    ResourceBundleMessageSource getResourceBundle() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages.properties");
        return source;
    }

    @Test
    void getAll() {

        // Set up mock data
        Addr addr1 = Addr.builder()
                .addrId(1L)
                .addrDesc("Address 1")
                .bldgId(10L)
                .cityName("City 1")
                .cntryName("Country 1")
                .strtId(100L)
                .strtName("Street 1")
                .build();
        Addr addr2 = Addr.builder()
                .addrId(2L)
                .addrDesc("Address 2")
                .bldgId(20L)
                .cityName("City 2")
                .cntryName("Country 2")
                .strtId(200L)
                .strtName("Street 2")
                .build();
        List<Addr> mockAddrList = new ArrayList<>();
        mockAddrList.add(addr1);
        mockAddrList.add(addr2);

        // Set up mock behavior
        when(iAddrRepository.findAll()).thenReturn(mockAddrList);
        // Call method under test
        DataResult<List<GetAllAddrResponse>> result = addrManager.getAll();
        // Verify result

        assertNotNull(result);
        //assertEquals("All address have been successfully called", result.getMessage());
        assertNotNull(result.getData());
        //assertEquals(2, result.getData().size());
        assertEquals(1L, result.getData().get(0).getAddrId());
        assertEquals("Address 1", result.getData().get(0).getAddrDesc());
        assertEquals(10L, result.getData().get(0).getBldgId());
        assertEquals("City 1", result.getData().get(0).getCityName());
        assertEquals("Country 1", result.getData().get(0).getCntryName());
        assertEquals(100L, result.getData().get(0).getStrtId());
        assertEquals("Street 1", result.getData().get(0).getStrtName());

        assertEquals(2L, result.getData().get(1).getAddrId());
        assertEquals("Address 2", result.getData().get(1).getAddrDesc());
        assertEquals(20L, result.getData().get(1).getBldgId());
        assertEquals("City 2", result.getData().get(1).getCityName());
        assertEquals("Country 2", result.getData().get(1).getCntryName());
        assertEquals("Street 2", result.getData().get(1).getStrtName());

    }


    @Test
    void getById() {
        Addr addr = Addr.builder()
                .addrId(1L)
                .addrDesc("Address 1")
                .bldgId(10L)
                .cityName("City 1")
                .cntryName("Country 1")
                .strtId(100L)
                .strtName("Street 1")
                .build();

        // Set up mock behavior
        when(iAddrRepository.findById(1L)).thenReturn(java.util.Optional.of(addr));

        // Call method under test
        DataResult<GetAddrResponse> result = addrManager.getById(1L);

        // Verify result

        assertNotNull(result);
        assertEquals(iMessageSourceService.getMessage(Messages.Addr.addrReceived), result.getMessage());
        assertNotNull(result.getData());
        assertEquals(1L, result.getData().getAddrId());
        assertEquals("Address 1", result.getData().getAddrDesc());
        assertEquals(10L, result.getData().getBldgId());
        assertEquals("City 1", result.getData().getCityName());
        assertEquals("Country 1", result.getData().getCntryName());
        assertEquals(100L, result.getData().getStrtId());
        assertEquals("Street 1", result.getData().getStrtName());
    }

    @Test
    void addAddr() {
        CreateAddrRequest createAddressRequest = CreateAddrRequest.builder()
                .addrDesc("Address 1")
                .cityName("City 1")
                .strtName("Street 1")
                .build();
        Addr addrToAdd = Addr.builder()
                .addrDesc("Address 1")
                .bldgId(10L)
                .cityName("City 1")
                .cntryName("Country 1")
                .strtId(100L)
                .strtName("Street 1")
                .build();
        when(iAddrRepository.save(any())).thenReturn(addrToAdd);
        Result response = addrManager.addAddr(createAddressRequest);

        assertNotNull(when(iAddrRepository.save(any())).thenReturn(addrToAdd));
        assertEquals(iMessageSourceService.getMessage(Messages.Addr.addrAdded), response.getMessage());


    }

    @Test
    void deleteAddr() {
        DeleteAddrRequest deleteAddrRequest=new DeleteAddrRequest();
        deleteAddrRequest.setAddrId(1L);
        Addr addr = Addr.builder()
                .addrId(1L)
                .addrDesc("Address 1")
                .bldgId(10L)
                .cityName("City 1")
                .cntryName("Country 1")
                .strtId(100L)
                .isActv(1L)
                .build();


        when(iAddrRepository.findById(1L)).thenReturn(java.util.Optional.of(addr));
        when(iAddrRepository.save(any())).thenReturn(addr);


       Result result = addrManager.deleteAddr(deleteAddrRequest);


        assertEquals(iMessageSourceService.getMessage(Messages.Addr.addrDeleted),result.getMessage());
        assertEquals(0, addr.getIsActv());
    }


    @Test
    void updateAddr() {
        // Set up mock data
        Addr addr = Addr.builder()
                .addrId(1L)
                .rowId(1L)
                .dataTpId(1L)
                .strtId(100L)
                .bldgId(20L)
                .addrDesc("Address 1")
                .isActv(1L)
                .cityName("City 1")
                .strtName("Street 1")
                .bldgName("Building 1")
                .cntryName("Country 1")
                .build();
        UpdateAddrRequest updateAddrRequest = UpdateAddrRequest.builder()
                .addrId(1L)
                .addrDesc("Updated Address")
                .cityName("Updated City")
                .strtName("Updated Street")
                .bldgName("Updated Building")
                .build();

        // Set up mock behavior
        when(iAddrRepository.findById(1L)).thenReturn(java.util.Optional.of(addr));
        when(iAddrRepository.save(any())).thenReturn(addr);
        // Call method under test
        Result result = addrManager.updateAddr(updateAddrRequest);

        // Verify result
        assertNotNull(result);
        assertEquals(iMessageSourceService.getMessage(Messages.Addr.addrUpdated), result.getMessage());
        assertEquals(1L, addr.getAddrId());
        assertEquals(1L, addr.getRowId());
        assertEquals(1L, addr.getDataTpId());
        assertEquals(100L, addr.getStrtId());
        assertEquals(20L, addr.getBldgId());
        assertEquals("Updated Address", addr.getAddrDesc());
        assertEquals(1L, addr.getIsActv());
        assertEquals("Updated City", addr.getCityName());
        assertEquals("Updated Street", addr.getStrtName());
        assertEquals("Updated Building", addr.getBldgName());
        assertEquals("Country 1", addr.getCntryName());
    }



}