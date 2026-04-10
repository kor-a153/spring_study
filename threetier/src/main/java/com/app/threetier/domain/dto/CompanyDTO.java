package com.app.threetier.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CompanyDTO {
    private Long id;
    private String companyName;
    private String getToWorkDateTime;
    private String leaveToWorkDateTime;
}
