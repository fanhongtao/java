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
package org.fanhongtao.tools.tagviewer.bean;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2011-11-20
 */
public class TitleBean {
    private String columnName;

    private String columnValue;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer(1024);
        buf.append("\tTitle, columnName=\"").append(columnName);
        buf.append("\", columnValue=\"").append(columnValue).append("\"");
        return buf.toString();
    }

}
