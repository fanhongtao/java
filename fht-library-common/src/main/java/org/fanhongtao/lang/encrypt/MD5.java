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
 * @deprecated MD5 is not safe enough, please use SHA-256
 */
public class MD5 {
    private MD5() {
    }

    /**
     * Get md5 digest of a string
     * 
     * @param input
     * @return md5 digest
     */
    public static String getMd5String(String input) {
        return getMd5String(input.getBytes());
    }

    /**
     * Get md5 digest of a byte array.
     * 
     * @param bytes
     * @return md5 digest
     */
    public static String getMd5String(byte[] bytes) {
        String md5Result = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(bytes);
            md5Result = StringUtils.toHexString(md5.digest());
        } catch (NoSuchAlgorithmException e) {
            md5Result = null;
        }
        return md5Result;
    }

}
