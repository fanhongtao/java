/*
 * Copyright (C) 2008 Fan Hongtao (http://www.fanhongtao.org)
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
package org.fanhongtao.lang.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.fanhongtao.lang.StringUtils;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 * @created 2008-10-18
 */
public class SHA256 {
    private SHA256() {
    }

    /**
     * Get SHA256 digest of a string
     * 
     * @param input
     * @return SHA256 digest
     */
    public static String encrypt(String input) {
        return encrypt(input.getBytes());
    }

    /**
     * Get SHA256 digest of a byte array
     * 
     * @param bytes
     * @return SHA256 digest
     */
    public static String encrypt(byte[] bytes) {
        String result = null;
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            sha256.update(bytes);
            result = StringUtils.toHexString(sha256.digest());
        } catch (NoSuchAlgorithmException e) {
            result = null;
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(SHA256.encrypt("hello"));
    }

}
