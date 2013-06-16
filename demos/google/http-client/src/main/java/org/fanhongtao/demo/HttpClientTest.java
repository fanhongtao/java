/*
 * Copyright (C) 2013 Fan Hongtao (http://www.fanhongtao.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fanhongtao.demo;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

/** 
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2013-4-10
 */
public class HttpClientTest {
    public void run() {
        HttpTransport transport = new NetHttpTransport();
        HttpRequestFactory requestFactory = transport.createRequestFactory();

        testGet(requestFactory, "http://google.com/");
        testGet(requestFactory, "http://baidu.com/");
    }

    public void testGet(HttpRequestFactory requestFactory, String url) {
        System.out.println(url);
        HttpResponse response = null;
        try {
            HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(url));
            response = request.execute();

            System.out.println("Status code: " + response.getStatusCode());
            HttpUtils.printHeaders(response.getHeaders());
            System.out.println("---------------------------------------");
            System.out.println(IOUtils.toString(response.getContent(), response.getContentCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new HttpClientTest().run();
    }
}
