package com.app.restful.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class OpenApiServiceTests {
    @Autowired
    private OpenApiService openApiService;

    @Test
    public void fetchDataTest() throws java.io.IOException, java.net.URISyntaxException {
        log.info("openApiService : {}" ,openApiService.fetchData());
    }

    @Test
    public void fetchData2Test() throws java.io.IOException, java.net.URISyntaxException {
        log.info("openApiService : {}" ,openApiService.fetchData2());
    }
}
