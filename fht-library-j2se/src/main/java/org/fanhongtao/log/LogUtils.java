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
package org.fanhongtao.log;

import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 */
public final class LogUtils {
    public static final String DEFAULT_PATTERN_LAYOUT = "[%d{MM-dd HH:mm:ss,SSS}] [%p] [%t] [%F:%L] [%m]%n";

    /**
     * Initiate log4j in the a simply way.
     */
    public static void initBasicLog() {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.DEBUG);
        // changeRootLayout("%r [%t] [%F:%L] %p %c %x - %m%n");
        changeRootLayout("%d{yyyy-MM-dd HH:mm:ss} [%t] [%F:%L] %p - %m%n");
    }

    /**
     * Change the Layout of <i>Root Logger</i>.
     * @param pattern New pattern
     */
    public static void changeRootLayout(String pattern) {
        Enumeration<?> enmu = Logger.getRootLogger().getAllAppenders();
        while (enmu.hasMoreElements()) {
            Appender a = (Appender) enmu.nextElement();
            a.setLayout(new PatternLayout(pattern));
        }
    }
}
