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

import java.util.Map.Entry;
import java.util.Set;

import com.google.api.client.http.HttpHeaders;

/** 
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2013-4-10
 */
public class HttpUtils {
    public static void printHeaders(HttpHeaders headers) {
        Set<Entry<String, Object>> set = headers.entrySet();
        for (Entry<String, Object> entry : set) {
            System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
        }
    }
}
