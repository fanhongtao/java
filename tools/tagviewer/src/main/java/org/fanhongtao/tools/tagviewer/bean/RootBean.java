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
public class RootBean {
    private List<GroupBean> groupList = new ArrayList<GroupBean>();

    public List<GroupBean> getGroupList() {
        return groupList;
    }

    public void addGroup(GroupBean group) {
        this.groupList.add(group);
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer(1024);
        for (GroupBean group : groupList) {
            buf.append(group.toString());
            buf.append(StringUtils.CRLF);
        }
        return buf.toString();
    }

}
