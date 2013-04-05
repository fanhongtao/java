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

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxGraphSelectionModel;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 */
public class TreeDemo extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField field;

    public TreeDemo() {
        super("Tree Demo");

        TreeNode rootNode = new TreeNode("Root");
        rootNode.addChild(new TreeNode("Hello"));
        rootNode.addChild(new TreeNode("World"));

        mxGraph graph = new mxGraph();
        graph.setAllowDanglingEdges(false);
        graph.setAutoSizeCells(true);
        graph.getSelectionModel().addListener(mxEvent.CHANGE, new mxIEventListener() {
            @Override
            public void invoke(Object sender, mxEventObject evt) {
                if (sender instanceof mxGraphSelectionModel) {
                    for (Object cell : ((mxGraphSelectionModel) sender).getCells()) {
                        mxCell mxCell = (mxCell) cell;
                        if (mxCell.isVisible()) {
                            field.setText(mxCell.getValue().toString());
                        }
                    }
                }
            }
        });

        graph.getModel().beginUpdate();
        try {
            Object parent = graph.getDefaultParent();
            mxCell rootCell = (mxCell) graph.insertVertex(parent, null, rootNode, 20, 20, 80, 30);
            rootCell.setConnectable(false);

            for (int i = 0, n = rootNode.getChildren().size(); i < n; i++) {
                TreeNode childNode = rootNode.getChildren().get(i);
                mxCell childCell = (mxCell) graph.insertVertex(parent, null, childNode, 20 + (i * 100), 80, 80, 30);
                childCell.setConnectable(false);

                graph.insertEdge(parent, null, null, rootCell, childCell, "edgeStyle=elbowEdgeStyle;elbow=vertical;"
                        + "exitX=0.5;exitY=1;exitPerimter=1;entryX=0.5;entryY=0;entryPerimter=1;");
            }
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent component = new mxGraphComponent(graph);
        add(component, BorderLayout.CENTER);

        field = new JTextField();
        field.setToolTipText("Show selected node");
        add(field, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        TreeDemo frame = new TreeDemo();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
