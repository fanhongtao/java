/*
 * Copyright (C) 2010 Fan Hongtao (http://www.fanhongtao.org)
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
package org.fanhongtao.demo.bean;

import java.util.ArrayList;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2010-10-7
 */
public class ServicesBean {
    private ArrayList<RequestBean> requestList = new ArrayList<RequestBean>();

    public void addRequest(RequestBean request) {
        requestList.add(request);
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        int i = 0;
        String CRLF = System.getProperty("line.separator");
        for (RequestBean req : requestList) {
            buf.append("Request ").append(++i);
            buf.append(CRLF);
            buf.append("\tinput: ").append(req.getInput());
            buf.append(CRLF);
            buf.append("\tservice: ").append(req.getService());
            buf.append(CRLF);
        }
        return buf.toString();
    }

}
