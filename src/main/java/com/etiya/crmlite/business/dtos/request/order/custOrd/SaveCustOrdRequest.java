package com.etiya.crmlite.business.dtos.request.order.custOrd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveCustOrdRequest {
    private Long OrdStId;

    private Long custId;

    private Long bsnInterId;

    private Long bsnInterSpecId;
}

