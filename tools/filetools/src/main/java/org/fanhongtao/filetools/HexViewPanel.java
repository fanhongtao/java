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

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.fanhongtao.lang.StringUtils;
import org.fanhongtao.swing.FileDropper;
import org.fanhongtao.swing.FileDropper.FileDropListener;

/** 
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2013-08-28
 */
public class HexViewPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextArea textArea;

    public HexViewPanel() {
        super(new BorderLayout());
        
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        textArea.setEditable(false);
        textArea.append("Drop a file to here\n");
        textArea.setFont(new Font("Consolas", Font.PLAIN, 16));
//         textArea.setFont(new Font("Courier New", Font.PLAIN, 16));
        new DropTarget(textArea, DnDConstants.ACTION_COPY, new FileDropper(new FileDropListener() {

            @Override
            public void onDropFile(File file) {
                showHex(file);
            }
        }));
    }

    private void showHex(File file) {
        try {
            byte[] bytes = FileUtils.readFileToByteArray(file);
            textArea.setText(StringUtils.toEditorHexString(bytes));
            textArea.setToolTipText(file.getName());
        } catch (Exception e) {
            textArea.setText("Failed to read file: " + file.getAbsolutePath());
        }
    }
}
