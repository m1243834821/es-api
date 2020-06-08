package com.example.demo;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    RestHighLevelClient restHighLevelClient;
    @Test
    void contextLoads() throws Exception{
        //创建索引
        CreateIndexRequest student = new CreateIndexRequest("student");
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(student, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

}
