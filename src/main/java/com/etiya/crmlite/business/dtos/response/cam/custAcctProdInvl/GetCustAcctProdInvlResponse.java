package com.etiya.crmlite.business.dtos.response.cam.custAcctProdInvl;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetCustAcctProdInvlResponse {
    private Long custAcctProdInvlId;

    private Long custAcctId;

    private Long prodId;

    private String shrtCode;

    private Long stId;
}
