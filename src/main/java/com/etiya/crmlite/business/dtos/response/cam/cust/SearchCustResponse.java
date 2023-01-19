package com.etiya.crmlite.business.dtos.response.cam.cust;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchCustResponse {
    private Long natId;
    private Long custId;
    private String roleName;
    private String frstName;
    private String mName;
    private String lstName;
}
