/*
 * Copyright (C) 2013 Fan Hongtao (http://fanhongtao.github.io/)
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
package org.fanhongtao.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** 
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2013-07-27
 */
@RunWith(JUnit4.class)
public class ReflectUtilTest {

    @Test
    public void getObjectByConstructor() {
        C1 c1 = (C1) ReflectUtil.getObjectByConstructor(C1.class.getName(), new Class<?>[] { String.class },
                new String[] { "hello" });
        // System.out.println(c1);
        assertEquals("hello", c1.getC1Name());
    }

    @Test
    public void setField_3() {
        C1 c1 = new C1("hello");
        // System.out.println(c1);
        assertEquals("hello", c1.getC1Name());

        ReflectUtil.setField(c1, "name", "world");
        // System.out.println(c1);
        assertEquals("world", c1.getC1Name());
    }

    @Test
    public void setField_4() {
        C2 c2 = new C2("hello");
        // System.out.println(c2);
        assertEquals("hello", c2.getC1Name());
        assertEquals("hello", c2.getC2Name());

        ReflectUtil.setField(c2, "name", "Hi");
        // System.out.println(c2);
        assertEquals("Hi", c2.getC2Name());

        ReflectUtil.setField(C2.class, c2, "name", "Good");
        assertEquals("Good", c2.getC2Name());

        ReflectUtil.setField(C1.class, c2, "name", "day");
        // System.out.println(c2);
        assertEquals("day", c2.getC1Name());
    }

    @Test
    public void getField_2() {
        C1 c1 = new C1("hello");
        assertEquals("hello", c1.getC1Name());
        assertEquals(c1.getC1Name(), ReflectUtil.getField(c1, "name"));
    }

    @Test
    public void getField_3() {
        C2 c2 = new C2("hello");
        c2.setC2Name("hi");
        c2.setC1Name("jack");
        assertEquals("hi", c2.getC2Name());
        assertEquals("jack", c2.getC1Name());
        assertEquals(c2.getC1Name(), ReflectUtil.getField(C1.class, c2, "name"));
        assertEquals(c2.getC2Name(), ReflectUtil.getField(C2.class, c2, "name"));
        // System.out.println(c2);
    }

    @Test
    public void callMethod() {
        C1 c1 = new C1("hello");
        // System.out.println(c1);
        assertEquals("hello", c1.getC1Name());

        ReflectUtil.callMethod(c1, "setC1Name", new Class<?>[] { String.class }, new String[] { "hi" });
        // System.out.println(c1);
        assertEquals("hi", c1.getC1Name());
    }

    private static class C1 {
        String name;

        public C1(String name) {
            super();
            this.name = name;
        }

        public void setC1Name(String name) {
            this.name = name;
        }

        public String getC1Name() {
            return name;
        }

        @Override
        public String toString() {
            return "[ " + name + " ]";
        }
    }

    private static class C2 extends C1 {
        String name;

        public C2(String name) {
            super(name);
            this.name = name;
        }

        public void setC2Name(String name) {
            this.name = name;
        }

        public String getC2Name() {
            return name;
        }

        @Override
        public String toString() {
            return "[ " + name + ", " + super.toString() + " ]";
        }
    }
}
