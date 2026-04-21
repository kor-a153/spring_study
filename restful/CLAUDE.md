# Restful API Project

## 기술 스택
- Spring Boot 3.4.4 / Gradle / Java
- MyBatis (XML 매퍼) / Oracle XE
- Swagger/OpenAPI (springdoc-openapi 2.8.1)
- Lombok / HikariCP
- 서버 포트: 10000

## 패키지 구조
```
com.app.restful
├── api/          ← REST 컨트롤러 (@RestController)
├── config/       ← 설정 클래스 (Swagger, CORS, MyBatis)
├── controller/   ← 전역 예외 핸들러
├── domain/
│   ├── dto/      ← Request/Response DTO
│   └── vo/       ← Value Object (DB 매핑)
├── exception/    ← 커스텀 예외 (MemberException, PostException)
├── mapper/       ← MyBatis 인터페이스 (@Mapper)
├── repository/   ← DAO (Optional 래핑)
└── service/      ← 비즈니스 로직 인터페이스 + Impl
```

## 아키텍처 흐름
```
API Controller → Service → DAO(Repository) → Mapper(@Mapper) → Oracle DB
```

## 공통 응답 포맷
모든 API 응답은 `ApiResponseDTO<T>` 래퍼 사용:
```java
ApiResponseDTO.of("조회 성공", data)   // 데이터 있을 때
ApiResponseDTO.of("삭제 성공")         // 데이터 없을 때
```

## 예외 처리 패턴
```java
// 서비스에서 예외 발생
throw new MemberException("회원을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST);
throw new PostException("게시글을 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

// CustomExceptionHandler가 자동으로 ResponseEntity 변환
```

## Swagger 어노테이션 패턴

### Controller 클래스
```java
@Tag(name = "Member API", description = "회원 관련 API")
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberAPI { ... }
```

### 메서드
```java
@Operation(summary = "회원 조회", description = "회원번호로 단일 회원 정보를 조회합니다.")
@ApiResponse(responseCode = "200", description = "조회 성공")
@ApiResponse(responseCode = "400", description = "회원 없음")
@GetMapping("/{id}")
public ResponseEntity<ApiResponseDTO<MemberResponseDTO>> getMemberInfo(@PathVariable Long id) { ... }
```

### Path Parameter
```java
@Parameter(
    name = "id",
    description = "회원번호",
    required = true,
    in = ParameterIn.PATH,
    example = "1",
    schema = @Schema(type = "number")
)
@PathVariable Long id
```

### Query Parameter
```java
@Parameter(
    name = "order",
    description = "정렬 기준 (desc: 최신순, oldest: 오래된순, read: 조회수순)",
    in = ParameterIn.QUERY,
    example = "desc",
    schema = @Schema(type = "string")
)
@RequestParam(defaultValue = "desc") String order
```

## VO 팩토리 메서드 패턴
```java
// DTO → VO 변환
MemberVO memberVO = MemberVO.from(memberJoinRequestDTO);
PostVO postVO = PostVO.from(postCreateRequestDTO);

// VO → DTO 변환
MemberResponseDTO dto = MemberResponseDTO.from(memberVO);
```

## Service 패턴
```java
@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    // ...
}
```

## DAO 패턴 (Optional 사용)
```java
// 단건 조회: Optional 반환
Optional<MemberVO> found = memberDAO.findById(id);
MemberVO member = found.orElseThrow(() ->
    new MemberException("회원을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST));
```

## MyBatis Mapper XML 위치
- `src/main/resources/mapper/memberMapper.xml`
- `src/main/resources/mapper/postMapper.xml`
- `src/main/resources/config/config.xml`

## DB 테이블 / 시퀀스
- `TBL_MEMBER` / `SEQ_MEMBER`
- `TBL_POST` / `SEQ_POST`

## 컬럼-필드 매핑 (snake_case → camelCase 자동)
- `MEMBER_EMAIL` → `memberEmail`
- `POST_READ_COUNT` → `postReadCount`
- `MEMBER_ID` → `memberId`

## 테스트 패턴
```java
@SpringBootTest
@Slf4j
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;

    @Test
    public void getMember() {
        log.info("result : {}", memberService.getMemberInfo(1L));
    }
}
```

## 도메인별 HTTP 상태 코드 관례
| 상황 | 상태 코드 |
|------|----------|
| 조회 성공 | 200 |
| 생성 성공 | 201 |
| 이메일 중복 | 409 CONFLICT |
| 로그인 실패 | 401 UNAUTHORIZED |
| 권한 없음 | 403 FORBIDDEN |
| 회원/게시글 없음 | 400 / 404 |
