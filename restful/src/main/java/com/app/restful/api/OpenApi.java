package com.app.restful.api;

import com.app.restful.domain.dto.ApiResponseDTO;
import com.app.restful.domain.dto.CongestionDTO;
import com.app.restful.domain.dto.PetTourDTO;
import com.app.restful.service.OpenApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/open-apis")
@RequiredArgsConstructor
@Tag(name = "OpenApi", description = "공공 API 연동 컨트롤러")
public class OpenApi {
    private final OpenApiService openApiService;

    @GetMapping("/pet-tour-list")
    @Operation(summary = "반려동물 여행지 목록 조회", description = "공공 데이터를 활용하여 반려동물 동반이 가능한 여행지 목록을 조회합니다.")
    public ResponseEntity<ApiResponseDTO<List<PetTourDTO>>> getPetTourList() throws java.io.IOException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO
                        .of("펫투어리스트 조회완료",openApiService.fetchData()));
    }

    @GetMapping("/congestion")
    @Operation(summary = "지하철 혼잡도(교통체증) 조회", description = "공공 데이터를 활용하여 지하철 혼잡도 정보를 조회합니다.")
    public ResponseEntity<ApiResponseDTO<CongestionDTO>> getTraffic() throws java.io.IOException, URISyntaxException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO
                        .of("교통체증 조회완료", openApiService.fetchData2()));
    }
}
