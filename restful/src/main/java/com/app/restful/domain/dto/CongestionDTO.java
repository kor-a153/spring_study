package com.app.restful.domain.dto;

import com.app.restful.domain.dto.CongestionDataDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

//  "page": 0,
//          "perPage": 0,
//          "totalCount": 0,
//          "currentCount": 0,
//          "matchCount": 0,
//          "data"
@Component
@Data
@Schema(description = "교통 체증 응답 DTO")
public class CongestionDTO {
//    키이름이 같으면 js 프로퍼티 생략가능
    @JsonProperty("page")
    @Schema(description = "현재 페이지 번호", example = "1")
    private Integer page;

    @Schema(description = "페이지당 결과 수", example = "10")
    private Integer perPage;

    @Schema(description = "전체 데이터 수", example = "100")
    private Integer totalCount;

    @Schema(description = "현재 페이지 데이터 수", example = "10")
    private Integer currentCount;

    @Schema(description = "매칭 데이터 수", example = "10")
    private Integer matchCount;

    @JsonProperty("data")
    @Schema(description = "교통 체증 상세 데이터 목록")
    private List<CongestionDataDTO> congestionList;


}
