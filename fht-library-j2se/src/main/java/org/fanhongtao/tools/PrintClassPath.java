/*
 * Copyright (C) 2013 Fan Hongtao (http://fanhongtao.github.io/)
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
package org.fanhongtao.tools;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Print the class path of current JVM.<br>
 * <br>
 * Execute
 * <pre>
 * mvn compile
 * mvn exec:exec -Dexec.executable="java" -Dexec.args="-classpath %classpath org.fanhongtao.tools.PrintClassPath"
 * </pre>
 * 
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2013-08-31
 */
public class PrintClassPath {
    public static void main(String[] args) {
        String[] paths = System.getProperty("java.class.path").split(System.getProperty("path.separator"));
        Arrays.sort(paths, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        System.out.println("Path num : " + paths.length);
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
