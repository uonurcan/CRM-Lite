package com.etiya.crmlite.business.dtos.request.cam.cust;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteCustRequest {
    private Long custId;
}
