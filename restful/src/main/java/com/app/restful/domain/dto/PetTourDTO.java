package com.app.restful.domain.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "반려동물 동반 여행 정보 DTO")
public class PetTourDTO {
    @Schema(description = "지역 코드", example = "1")
    private String areacode;

    @Schema(description = "장소 명칭", example = "남산공원")
    private String title;

    @Schema(description = "콘텐츠 ID", example = "123456")
    private String contentid;

    @Schema(description = "우편번호", example = "04628")
    private String zipcode;

    @Schema(description = "기본 주소", example = "서울특별시 중구 삼일대로 231")
    private String addr1;

    @Schema(description = "상세 주소", example = "(예장동)")
    private String addr2;

    @Schema(description = "대표 이미지 URL", example = "http://.../image1.jpg")
    private String firstimage;

    @Schema(description = "썸네일 이미지 URL", example = "http://.../image2.jpg")
    private String firstimage2;

    @Schema(description = "전화번호", example = "02-123-4567")
    private String tel;

}
