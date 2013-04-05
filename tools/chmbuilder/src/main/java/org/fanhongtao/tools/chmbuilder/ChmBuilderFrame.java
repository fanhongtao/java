/*
 * Copyright (C) 2008 Fan Hongtao (http://www.fanhongtao.org)
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
package org.fanhongtao.tools.chmbuilder;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2008-11-12
 */
public class ChmBuilderFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField textChmFile;

    private JTextField textHtmlDir;

    private JTextField textDefaultHtml;

    private JButton createButton;
    final static int GAP = 10;

    public ChmBuilderFrame() {
        setTitle("CHM Builder");
        setSize(500, 180);
        JPanel panel = new JPanel(new SpringLayout());
        // panel.setLayout(new BorderLayout());
        // panel = new JPanel();
        // 创建输入选项的控件
        //panel.setLayout(new GridLayout(0, 2));
        add(panel, BorderLayout.CENTER);

        JLabel label = new JLabel();
        label.setText("CHM file");
        textChmFile = new JTextField();
        label.setLabelFor(textChmFile);
        panel.add(label);
        panel.add(textChmFile);

        label = new JLabel();
        label.setText("HTML directory");
        textHtmlDir = new JTextField();
        label.setLabelFor(textHtmlDir);
        panel.add(label);
        panel.add(textHtmlDir);

        label = new JLabel();
        label.setText("HTML index");
        textDefaultHtml = new JTextField();
        label.setLabelFor(textDefaultHtml);
        panel.add(label);
        panel.add(textDefaultHtml);
        SpringUtilities.makeCompactGrid(panel, 3, 2, GAP, GAP, GAP, GAP / 2);
        add(panel, BorderLayout.CENTER);

        // 设置缺省值
        textChmFile.setText("Apache.Lang.chm");
        textHtmlDir.setText("d:\\java\\Apache\\Commons\\apidocs");
        textDefaultHtml.setText("index.html");

        JPanel btnPanel = new JPanel();
        add(btnPanel, BorderLayout.SOUTH);
        createButton = new JButton();
        createButton.setText("Create");
        createButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buildChm();
            }

        });
        btnPanel.add(createButton);
    }

    private void buildChm() {
        String chmFile = textChmFile.getText();
        String htmlDir = textHtmlDir.getText();
        String defaultHtml = textDefaultHtml.getText();
        try {
            ChmBuilder builder = new ChmBuilder(chmFile, htmlDir, defaultHtml, null);
            builder.run();
            JOptionPane.showMessageDialog(this, "Build success.\nCHM file: " + builder.getChmFileName(), "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Build failed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ChmBuilderFrame frame = new ChmBuilderFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
