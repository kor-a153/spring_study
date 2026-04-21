package com.app.restful.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

//"요일구분": "string",
//        "호선": "string",
//        "역번호": 0,
//        "출발역": "string",
//        "상하구분": "string",
//        "5시30분": "string",
//        "6시00분": "string",
//        "6시30분": "string",
//        "7시00분": "string",
//        "7시30분": "string",
//        "8시00분": "string",
//        "8시30분": "string",
//        "9시00분": "string",
//        "9시30분": "string",
//        "10시00분": "string",
//        "10시30분": "string",
//        "11시00분": "string",
//        "11시30분": "string",
//        "12시00분": "string",
//        "12시30분": "string",
//        "13시00분": "string",
//        "13시30분": "string",
//        "14시00분": "string",
//        "14시30분": "string",
//        "15시00분": "string",
//        "15시30분": "string",
//        "16시00분": "string",
//        "16시30분": "string",
//        "17시00분": "string",
//        "17시30분": "string",
//        "18시00분": "string",
//        "18시30분": "string",
//        "19시00분": "string",
//        "19시30분": "string",
//        "20시00분": "string",
//        "20시30분": "string",
//        "21시00분": "string",
//        "21시30분": "string",
//        "22시00분": "string",
//        "22시30분": "string",
//        "23시00분": "string",
//        "23시30분": "string",
//        "00시00분": "string",
//        "00시30분": "string"

@Data@Component
@Schema(description = "교통 체증 상세 데이터 DTO")
public class CongestionDataDTO {
    @JsonProperty("요일구분")
    @Schema(description = "요일 구분", example = "평일")
    private String day;

    @JsonProperty("호선")
    @Schema(description = "지하철 호선", example = "1")
    private String line;

    @JsonProperty("역번호")
    @Schema(description = "역 번호", example = "150")
    private int stationNumber;

    @JsonProperty("출발역")
    @Schema(description = "출발역 이름", example = "서울역")
    private String startStation;

    @JsonProperty("상하구분")
    @Schema(description = "상하행 구분", example = "상선")
    private String upOrDownStation;

    @JsonProperty("5시30분")
    @Schema(description = "05:30 혼잡도", example = "20")
    private String time530;

    @JsonProperty("6시00분")
    @Schema(description = "06:00 혼잡도", example = "25")
    private String time600;

    @JsonProperty("6시30분")
    @Schema(description = "06:30 혼잡도", example = "30")
    private String time630;

    @JsonProperty("7시00분")
    @Schema(description = "07:00 혼잡도", example = "35")
    private String time700;

    @JsonProperty("7시30분")
    @Schema(description = "07:30 혼잡도", example = "50")
    private String time730;

}
