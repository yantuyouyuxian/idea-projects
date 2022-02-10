package com.zh.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @ Author         zhangHan
 * @ Date           2022/2/8 17:11
 * @ Description
 */
public class ESClientTest {


    public static RestHighLevelClient getESClient() {
        return new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
    }

    public static void closeClient(RestHighLevelClient esClient) throws IOException {
        esClient.close();
    }

    public static void main(String[] args) throws Exception {
        //创建es客户端
        RestHighLevelClient esClient = getESClient();
        //关闭客户端
        esClient.close();
    }
}
