/*
 * Copyright (C) 2011 Fan Hongtao (http://www.fanhongtao.org)
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
package org.fanhongtao.tools.treeviewer;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.fanhongtao.tools.treeviewer.bean.AttrBean;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2011-11-22
 */
public class AttrTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private List<AttrBean> attrList;

    public AttrTableModel(List<AttrBean> attrList) {
        super();
        this.attrList = attrList;
    }

    public void setAttrList(List<AttrBean> attrList) {
        this.attrList = attrList;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return attrList.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AttrBean tag = attrList.get(rowIndex);
        if (tag == null) {
            return null;
        }

        switch (columnIndex) {
        case 0:
            return tag.getName();
        case 1:
            return tag.getValue();
        default:
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
        case 0:
            return "Name";
        case 1:
            return "Value";
        default:
            return null;
        }
    }
}
