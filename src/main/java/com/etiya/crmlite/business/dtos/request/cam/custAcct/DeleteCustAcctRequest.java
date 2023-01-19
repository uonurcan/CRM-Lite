package com.etiya.crmlite.business.dtos.request.cam.custAcct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteCustAcctRequest {

    @NotNull
    private Long custAcctId;
}
