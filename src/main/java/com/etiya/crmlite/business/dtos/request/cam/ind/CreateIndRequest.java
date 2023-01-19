package com.etiya.crmlite.business.dtos.request.cam.ind;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateIndRequest {
    @NotBlank
    @NotNull
    private String frstName;
    private String mName;
    @NotBlank
    @NotNull
    private String lstName;

    @NotNull
    private LocalDate brthDate;

    @NotNull
    private Long gendrId;
    @NotBlank
    @NotNull
    private String mthrName;
    @NotBlank
    @NotNull
    private String fthrName;

    @NotNull
    private Long natId;
    @NotBlank
    @NotNull
    private String mobilePhone;
    private String fax;
    @NotBlank
    @NotNull
    private String eMail;
    private String homePhone;
    private String addressDescription;
    @NotBlank
    @NotNull
    private String cityName;
    @NotBlank
    @NotNull
    private String streetName;
    @NotBlank
    @NotNull
    private String buildingName;

   // List<CreateAddrWhenCreateIndRequest> createAddrWhenCreateIndRequestList;
}
