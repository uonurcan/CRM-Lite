package com.etiya.crmlite.business.dtos.request.cam.ind;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAddrWhenCreateIndRequest {
    @NotNull
    private String cntryName;

    @NotNull
    @Size(max=100)
    private String city;

    @NotNull
    @Size(max=100)
    private Long strt;

    @NotNull
    @Size(max=100)
    private String strtName;

    @NotNull
    @Size(max=100)
    private String bldgName;

    @NotNull
    @Size(max=100)
    private Long flatNumber;

    @NotNull
    @Size(max = 100)
    private String addrDesc;


}
