package com.googne.zippie.common.lib.util;

import java.util.Base64;

public class SecurityUtils {
    public static String encodeBase64(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public static String decodeBase64(String value) {
        return new String(Base64.getDecoder().decode(value));
    }
}
