/*
 * Copyright (C) 2013 Fan Hongtao (http://www.fanhongtao.org)
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

import java.awt.Dimension;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import org.fanhongtao.swing.BaseFrame;
import org.fanhongtao.swing.FileDropper;
import org.fanhongtao.swing.FileDropper.FileDropListener;
import org.fanhongtao.swing.FileTransferHandler;
import org.fanhongtao.swing.FileTransferHandler.FileTransferListener;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2013-6-16
 */
public class DropFileTest extends BaseFrame {

    @Override
    protected void createContents(JFrame frame) {
        final JTextArea dropTextArea = new JTextArea();
        dropTextArea.setEditable(false);
        dropTextArea.append("Accept drop file by FileDropper\n");
        new DropTarget(dropTextArea, DnDConstants.ACTION_COPY, new FileDropper(new FileDropListener() {

            @Override
            public void onDropFile(File file) {
                dropTextArea.append(file.getAbsolutePath() + "\n");
            }
        }));

        final JTextArea dropTextArea2 = new JTextArea();
        dropTextArea2.setEditable(false);
        dropTextArea2.append("Accept drop file by FileTransferHandler\n");
        dropTextArea2.setTransferHandler(new FileTransferHandler(new FileTransferListener() {

            @Override
            public void onDropFile(File file) {
                dropTextArea2.append(file.getAbsolutePath() + "\n");
            }
        }));

        // Create splite pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, dropTextArea, dropTextArea2);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(400);
        frame.add(splitPane);

        // Maxmize window
        frame.setSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        new DropFileTest().run("Drop file test");
    }
}
