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
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.util.List;

/** 
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2013-6-16
 */
public class FileDropper extends DropTargetAdapter {

    public interface FileDropListener {
        public void onDropFile(File file);
    }

    private FileDropListener listener;

    public FileDropper(FileDropListener listener) {
        super();
        this.listener = listener;
    }

    public void drop(DropTargetDropEvent event) {
        event.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
        Transferable transferable = event.getTransferable();
        DataFlavor[] transferFlavors = transferable.getTransferDataFlavors();
        for (DataFlavor flavor : transferFlavors) {
            try {
                if (flavor.equals(DataFlavor.javaFileListFlavor)) {
                    @SuppressWarnings("unchecked")
                    List<File> fileList = (List<File>) transferable.getTransferData(flavor);
                    for (File file : fileList) {
                        listener.onDropFile(file);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            event.dropComplete(true);
        }
    }
}
