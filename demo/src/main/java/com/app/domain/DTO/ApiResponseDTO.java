package com.app.domain.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor @AllArgsConstructor
@Schema(description = "서버응답 DTO")
public class ApiResponseDTO {
}
