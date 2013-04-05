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

import java.util.ArrayList;
import java.util.List;

import org.fanhongtao.lang.StringUtils;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2011-11-20
 */
public class GroupBean {
    private String name;

    private TitleBean title;

    private List<TagBean> tagList = new ArrayList<TagBean>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TitleBean getTitle() {
        return title;
    }

    public void setTitle(TitleBean title) {
        this.title = title;
    }

    public List<TagBean> getTagList() {
        return tagList;
    }

    public void addTag(TagBean tag) {
        this.tagList.add(tag);
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer(1024);
        buf.append("Group, name=").append(name).append(", ");
        buf.append(StringUtils.CRLF);
        if (title != null) {
            buf.append(title.toString());
            buf.append(StringUtils.CRLF);
        }
        for (TagBean tag : tagList) {
            buf.append("\t");
            buf.append(tag.toString());
            buf.append(StringUtils.CRLF);
        }
        buf.append("]");
        return buf.toString();
    }

}
