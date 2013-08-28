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
package org.fanhongtao.filetools;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import org.fanhongtao.swing.BaseFrame;

/** 
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2013-08-28
 */
public class FileTools extends BaseFrame {
    @Override
    protected void createContents(JFrame frame) {
        JTabbedPane tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);
        frame.setSize(new Dimension(800, 600));

        JComponent panel1 = new HexViewPanel();
        tabbedPane.addTab("Hex View", null, panel1, "Show hex-view of a file");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
    }

    public static void main(String[] args) {
        new FileTools().run("File Tools");
    }
}
