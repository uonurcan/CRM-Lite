package com.etiya.crmlite.business.dtos.request.cam.cust;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateCustRequest {
    private Long custId;
    private Long partyRole;
    private Long custTp;
    private Long stId;
}
