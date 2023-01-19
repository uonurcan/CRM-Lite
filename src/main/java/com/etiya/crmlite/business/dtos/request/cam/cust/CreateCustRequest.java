package com.etiya.crmlite.business.dtos.request.cam.cust;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCustRequest {
    private Long custTpId;
    private Long partyRoleId;

}
