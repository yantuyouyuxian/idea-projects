package com.zh.es;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.junit.Test;

import java.io.IOException;

/**
 * @ Author         zhangHan
 * @ Date           2022/2/8 17:23
 * @ Description
 */
public class ESClientIndex {

    @Test
    public void createIndex() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        // 创建索引
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("student");
        CreateIndexResponse response = esClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(response.index());
        System.out.println(response.isAcknowledged());
        ESClientTest.closeClient(esClient);
    }

    @Test
    public void queryIndex() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        GetIndexRequest getIndexRequest = new GetIndexRequest("student");
        GetIndexResponse response = esClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);

        ESClientTest.closeClient(esClient);
    }

    @Test
    public void deleteIndex() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        DeleteIndexRequest getIndexRequest = new DeleteIndexRequest("student");
        AcknowledgedResponse response = esClient.indices().delete(getIndexRequest, RequestOptions.DEFAULT);

        ESClientTest.closeClient(esClient);
    }

}
