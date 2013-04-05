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
package org.fanhongtao.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.log4j.BasicConfigurator;
import org.fanhongtao.demo.bean.ServicesBean;
import org.fanhongtao.xml.DigesterUtils;
import org.xml.sax.SAXException;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2010-10-7
 */
public class DigesterTest {

    public static void main(String args[]) throws IOException, SAXException {
        BasicConfigurator.configure();
        new DigesterTest().parse();
    }

    public void parse() throws IOException, SAXException {
        ServicesBean servicesBean = new ServicesBean();
        InputStream input = servicesBean.getClass().getResourceAsStream("test.xml");
        URL url = servicesBean.getClass().getResource("test_rules.xml");
        servicesBean = (ServicesBean) DigesterUtils.parse(servicesBean, input, url);
        System.out.println(servicesBean);
    }

}
