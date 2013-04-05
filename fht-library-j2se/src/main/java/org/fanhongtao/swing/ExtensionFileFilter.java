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

import java.io.File;
import java.util.ArrayList;

import javax.swing.filechooser.FileFilter;

/**
 * For JDK 1.5 only.
 * For JDK 1.6, use FileNameExtensionFilter .
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2009-5-6
 */
public class ExtensionFileFilter extends FileFilter {
    public void addExtension(String extension) {
        if (!extension.startsWith(".")) {
            extension = "." + extension;
        }
        extensions.add(extension);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String name = f.getName().toLowerCase();

        for (String ext : extensions) {
            if (name.endsWith(ext)) {
                return true;
            }
        }

        return false;
    }

    private String description = "";

    private ArrayList<String> extensions = new ArrayList<String>();

}
