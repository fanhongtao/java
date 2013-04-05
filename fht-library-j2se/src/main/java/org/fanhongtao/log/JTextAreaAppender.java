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

import java.io.StringWriter;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.apache.log4j.WriterAppender;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2010-10-31
 */
public class JTextAreaAppender extends WriterAppender {
    private JTextArea textArea;

    private StringWriter sw;

    public JTextAreaAppender(JTextArea textArea) {
        this.textArea = textArea;
        sw = new StringWriter(1024);
        setWriter(sw);
    }

    @Override
    public void append(LoggingEvent event) {
        sw.getBuffer().setLength(0);
        super.append(event);

        final String message = sw.toString();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                textArea.append(message);
            }
        });
    }
}
