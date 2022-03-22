package com.zh.es;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @ Author         zhangHan
 * @ Date           2022/2/8 17:48
 * @ Description
 */
public class ESClientDoc {
    // 插入
    @Test
    public void insertDoc() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        // 插入数据
        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");// 设置索引并自定义数据id
        User user = new User();
        user.setName("张三");
        user.setAge(39);
        user.setSex("男");

        ObjectMapper mapper = new ObjectMapper();
        String userString = mapper.writeValueAsString(user);

        request.source(userString, XContentType.JSON);

        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());

        ESClientTest.closeClient(esClient);
    }

    // 更新
    @Test
    public void updateDoc() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();

        UpdateRequest request = new UpdateRequest();
        request.index("user").id("1001");
        request.doc(XContentType.JSON, "sex", "女");// 局部更新

        UpdateResponse response = esClient.update(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());

        ESClientTest.closeClient(esClient);
    }

    // 查询
    @Test
    public void queryDoc() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        GetRequest request = new GetRequest();
        request.index("user").id("1001");
        GetResponse response = esClient.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
        ESClientTest.closeClient(esClient);
    }

    // 删除
    @Test
    public void deleteDoc() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1001");
        DeleteResponse response = esClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
        ESClientTest.closeClient(esClient);
    }

    // 批量插入
    @Test
    public void insertBatch() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();

        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest().index("user").id("2001").source(XContentType.JSON, "name", "bulk1", "age", "11", "sex", "男"));
        request.add(new IndexRequest().index("user").id("2002").source(XContentType.JSON, "name", "bulk2", "age", "22", "sex", "男"));
        request.add(new IndexRequest().index("user").id("2003").source(XContentType.JSON, "name", "bulk3", "age", "33", "sex", "女"));
        request.add(new IndexRequest().index("user").id("2004").source(XContentType.JSON, "name", "bulk4", "age", "44", "sex", "女"));
        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(Arrays.toString(response.getItems()));

        ESClientTest.closeClient(esClient);
    }

    // 批量删除
    @Test
    public void deleteBatch() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();

        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest().index("user").id("0001"));
        request.add(new DeleteRequest().index("user").id("0002"));
        request.add(new DeleteRequest().index("user").id("0003"));
        request.add(new DeleteRequest().index("user").id("0004"));
        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(Arrays.toString(response.getItems()));

        ESClientTest.closeClient(esClient);
    }

    // 全量查询
    @Test
    public void queryAll() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();

        SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        request.source(sourceBuilder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        SearchHits hits = response.getHits();

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        ESClientTest.closeClient(esClient);
    }

    // 条件查询
    @Test
    public void queryCondition() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        SearchRequest request = new SearchRequest();
        request.indices("user");
        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age", "22")));

        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        SearchHits hits = response.getHits();

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        ESClientTest.closeClient(esClient);
    }

    // 分页查询
    @Test
    public void queryPage() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.from(0);
        builder.size(2);
        request.source(builder);

        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        SearchHits hits = response.getHits();

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        ESClientTest.closeClient(esClient);
    }

    // 排序
    @Test
    public void querySort() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.sort("age", SortOrder.DESC);
        request.source(builder);

        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        SearchHits hits = response.getHits();

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        ESClientTest.closeClient(esClient);
    }

    // 查询指定字段
    @Test
    public void queryFilterField() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.fetchSource(new String[]{"name", "sex"}, new String[]{});
        request.source(builder);

        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        SearchHits hits = response.getHits();

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        ESClientTest.closeClient(esClient);
    }

    // 组合条件查询
    @Test
    public void queryMultiConditions() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

//        boolQuery.must(QueryBuilders.matchQuery("sex","男"));
//        boolQuery.mustNot(QueryBuilders.matchQuery("sex","女"));
//        boolQuery.must(QueryBuilders.matchQuery("name","bulk1"));

        boolQuery.should(QueryBuilders.matchQuery("sex","男"));
        boolQuery.should(QueryBuilders.matchQuery("age","33"));

        builder.query(boolQuery);

        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        SearchHits hits = response.getHits();

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        ESClientTest.closeClient(esClient);
    }

    // 范围查询
    @Test
    public void queryRangeConditions() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");

        rangeQuery.gte(30);

        builder.query(rangeQuery);

        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        SearchHits hits = response.getHits();

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        ESClientTest.closeClient(esClient);
    }

    // 模糊查询
    @Test
    public void queryFuzzy() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        FuzzyQueryBuilder fuzzyQuery = QueryBuilders.fuzzyQuery("name", "bulk1").fuzziness(Fuzziness.ZERO);

        builder.query(fuzzyQuery);

        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        SearchHits hits = response.getHits();

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        ESClientTest.closeClient(esClient);
    }

    // 高亮查询
    @Test
    public void queryHighLight() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("name", "bulk1");
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color ='red'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("name");
        builder.highlighter(highlightBuilder);
        builder.query(queryBuilder);

        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        SearchHits hits = response.getHits();

        for (SearchHit hit : hits) {
            System.out.println(hit);
        }

        ESClientTest.closeClient(esClient);
    }

    // 聚合查询
    @Test
    public void queryAggregate() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        AvgAggregationBuilder avgAggregationBuilder = AggregationBuilders.avg("avgAge").field("age");
        builder.aggregation(avgAggregationBuilder);

        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());


        ESClientTest.closeClient(esClient);
    }

    // 分组查询
    @Test
    public void queryGroupBy() throws IOException {
        RestHighLevelClient esClient = ESClientTest.getESClient();
        SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("ageTerm").field("age");
        builder.aggregation(termsAggregationBuilder);

        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());


        ESClientTest.closeClient(esClient);
    }

}
