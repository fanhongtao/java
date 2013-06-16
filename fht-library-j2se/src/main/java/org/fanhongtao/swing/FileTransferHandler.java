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
package org.fanhongtao.swing;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

/** 
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2013-6-16
 */
public class FileTransferHandler extends TransferHandler {
    private static final long serialVersionUID = -7264784447347750456L;

    private FileTransferListener listener;

    public interface FileTransferListener {
        public void onDropFile(File file);
    }

    public FileTransferHandler(FileTransferListener listener) {
        super();
        this.listener = listener;
    }

    public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
        for (DataFlavor flavor : transferFlavors) {
            if (flavor.equals(DataFlavor.javaFileListFlavor)) {
                return true;
            }
        }
        return false;
    }

    public boolean importData(JComponent comp, Transferable t) {
        DataFlavor[] transferFlavors = t.getTransferDataFlavors();
        for (DataFlavor flavor : transferFlavors) {
            try {
                if (flavor.equals(DataFlavor.javaFileListFlavor)) {
                    @SuppressWarnings("unchecked")
                    List<File> list = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
                    for (File file : list) {
                        listener.onDropFile(file);
                    }
                    return true;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
