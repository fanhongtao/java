/*
 * Copyright (C) 2010 Fan Hongtao (http://www.fanhongtao.org)
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
package org.fanhongtao.thread;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 */
public abstract class ExRunnable implements Runnable {
    /** 是否终止运行 */
    private boolean stoped = false;

    /** 名字 */
    private String name = "";

    public synchronized boolean isStoped() {
        return stoped;
    }

    public synchronized void setStoped(boolean stoped) {
        this.stoped = stoped;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
