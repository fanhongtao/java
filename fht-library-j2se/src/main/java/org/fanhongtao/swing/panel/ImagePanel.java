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

import java.awt.Graphics;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 一个专门显示图片的Panel
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2009-5-17
 */
public class ImagePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public ImagePanel(File file) {
        try {
            image = ImageIO.read(file);
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImagePanel(byte[] imageContent) {
        try {
            image = ImageIO.read(new ByteArrayInputStream(imageContent));
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        if (image == null) {
            return;
        }

        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
        this.setSize(imageWidth, imageHeight);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, null);
    }

    /** 所要显示的图片 */
    private Image image;
}
