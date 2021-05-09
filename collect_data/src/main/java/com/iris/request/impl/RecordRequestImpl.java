package com.iris.request.impl;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import com.iris.request.RecordRequest;
import com.iris.util.RequestBuild;

import java.io.IOException;

@Component
public class RecordRequestImpl implements RecordRequest {
    public String getRecordByStockNumber(String stockNumber) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        String requestUrl=RequestBuild.buildRecordRequestUrl(String.valueOf(stockNumber));
        HttpGet getRequest = new HttpGet(requestUrl);
        CloseableHttpResponse response = null;

        // start execute com.iris.request
        try {
            response = client.execute(getRequest);
            HttpEntity responseEntity = response.getEntity();
            StatusLine statusLine = response.getStatusLine();
            if (statusLine != null) {
                return EntityUtils.toString(responseEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
