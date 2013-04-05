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
package org.fanhongtao.lang;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2010-10-29
 */
public class PropertiesUtils {
    public static Properties readFromFile(String fileName) throws IOException {
        Properties properties = new Properties();
        InputStream inStream = new BufferedInputStream(new FileInputStream(fileName));
        properties.load(inStream);
        inStream.close();
        return properties;
    }

    public static Properties readFromFileQuite(String fileName) {
        Properties properties = null;
        try {
            properties = readFromFile(fileName);
        } catch (IOException e) {
            properties = new Properties();
        }
        return properties;
    }

    public static void writeToFile(String fileName, Properties properties, String comments) throws IOException {
        OutputStream outStream = new BufferedOutputStream(new FileOutputStream(fileName));
        properties.store(outStream, comments);
        outStream.close();
    }

    public static void writeToFileQuite(String fileName, Properties properties, String comments) {
        try {
            writeToFile(fileName, properties, comments);
        } catch (IOException e) {
        }
    }
}
