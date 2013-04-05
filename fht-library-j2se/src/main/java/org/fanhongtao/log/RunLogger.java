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

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 */
public class RunLogger {
    private static String FQCN;

    private static Logger logger;

    public void init() {
        FQCN = RunLogger.class.getName();
        logger = Logger.getLogger(RunLogger.class.getName());
    }

    public static void error(String msg) {
        logger.log(FQCN, Level.ERROR, msg, null);
    }

    public static void error(String msg, Throwable thrown) {
        logger.log(FQCN, Level.ERROR, msg, thrown);
    }

    public static void warn(String msg) {
        logger.log(FQCN, Level.WARN, msg, null);
    }

    public static void warn(String msg, Throwable thrown) {
        logger.log(FQCN, Level.WARN, msg, thrown);
    }

    public static void info(String msg) {
        logger.log(FQCN, Level.INFO, msg, null);
    }

    public static void info(String msg, Throwable thrown) {
        logger.log(FQCN, Level.INFO, msg, thrown);
    }

    public static void debug(String msg) {
        logger.log(FQCN, Level.DEBUG, msg, null);
    }

    public static void debug(String msg, Throwable thrown) {
        logger.log(FQCN, Level.DEBUG, msg, thrown);
    }
}
