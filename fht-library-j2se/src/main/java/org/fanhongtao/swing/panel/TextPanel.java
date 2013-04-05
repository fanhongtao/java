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
package org.fanhongtao.swing.panel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2009-5-18
 */
public class TextPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextComponent component;

    public TextPanel(String text, JTextComponent component) {
        // this.setLayout(new GridLayout(0, 2));
        // this.setLayout(new BorderLayout());
        this.setLayout(new BorderLayout(10, 10));
        this.component = component;
        int idx = text.indexOf('&');
        JLabel label;
        if (idx == -1) {
            label = new JLabel(text);
        } else {
            text = text.substring(0, idx) + text.substring(idx + 1);
            char ch = text.charAt(idx);
            label = new JLabel(text);
            label.setDisplayedMnemonic((int) ch);
            component.setFocusAccelerator(ch);
        }
        add(label, BorderLayout.WEST);
        add(component, BorderLayout.CENTER);
    }

    public JTextComponent getComponent() {
        return component;
    }
}
