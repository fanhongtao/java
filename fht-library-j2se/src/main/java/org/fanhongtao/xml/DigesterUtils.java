/*
 * Copyright (C) 2009 Fan Hongtao (http://www.fanhongtao.org)
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
package org.fanhongtao.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2009-6-3
 */
public final class DigesterUtils {

    /**
     * 从XML文件中读取数据
     * 
     * @param obj 保存数据的对象
     * @param inputUrl 所要读取的XML文件对应的URL
     * @param rulesUrl XML文件读取规则对应的URL
     * @return 读取数据后对应的对象，如果读取失败，则返回null
     */
    public static Object parse(Object obj, URL inputUrl, URL rulesUrl) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(inputUrl.getFile());
            obj = parse(obj, inputStream, rulesUrl);
        } catch (Exception e) {
            //RunLogger.warn("Failed to read XML", e);
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
        return obj;
    }

    public static Object parse(Object obj, InputStream inputStream, URL rulesUrl) throws IOException, SAXException {
        Digester digester = DigesterLoader.createDigester(rulesUrl);
        digester.push(obj);
        digester.setValidating(false);
        return digester.parse(inputStream);
    }

    public static void closeLog() {
        // Close log for Digester 1.8
        Logger.getLogger("org.apache.commons.digester.Digester").setLevel(Level.OFF);
        Logger.getLogger("org.apache.commons.beanutils.BeanUtils").setLevel(Level.OFF);
        Logger.getLogger("org.apache.commons.beanutils.ConvertUtils").setLevel(Level.OFF);

        // Close log for Digester 2.0
        Logger.getLogger("org.apache.commons.beanutils.converters").setLevel(Level.OFF);
    }
}
