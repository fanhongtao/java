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
package org.fanhongtao.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 */
public class TreeNode implements Serializable {
    private static final long serialVersionUID = 1L;
    private TreeNode parent;
    private List<TreeNode> children;
    private String value;

    public TreeNode(String value) {
        this.parent = null;
        this.children = new ArrayList<TreeNode>();
        this.value = value;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public String getValue() {
        return value;
    }

    public void addChild(TreeNode treeNode) {
        children.add(treeNode);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return value;
    }

}
