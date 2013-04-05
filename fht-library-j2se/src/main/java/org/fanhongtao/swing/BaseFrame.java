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
package org.fanhongtao.swing;

import javax.swing.JFrame;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2009-5-18
 */
public abstract class BaseFrame {
    private JFrame frame;

    public void run(String title) {
        frame = new JFrame();
        frame.setTitle(title);
        createContents(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    abstract protected void createContents(JFrame frame);

    protected JFrame getFrame() {
        return frame;
    }

}
