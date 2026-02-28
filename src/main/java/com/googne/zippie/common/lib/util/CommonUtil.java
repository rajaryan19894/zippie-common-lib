package com.googne.zippie.common.lib.util;

//import com.googne.expy.model.fileUpload.FileFormat;
import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.io.FilenameUtils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CommonUtil {
    public static boolean isValid(Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }

    public static boolean isValid(Map<?, ?> map) {
        return Objects.nonNull(map) && !map.isEmpty();
    }

    public static boolean isValid(String str) {
        return Objects.nonNull(str) && !str.isEmpty();
    }

    public static String generateKeyword(List<String> data) {
        if (!isValid(data))
            throw new RuntimeException("Invalid data for generate keyword" + data);

        List<String> normalized = data.stream()
                .map(String::toLowerCase)
                .map(str -> str.replaceAll(" ", ""))
                .distinct()
                .sorted()
                .toList();

        return String.join("|", normalized);
    }

    public static String hash(String str) {
        return DigestUtils.sha256Hex(str);
    }


    private static String generateEntityNumber(String prefix, String parentNumber) {
        return Objects.nonNull(parentNumber)
                ? parentNumber + DateUtil.keywordDateTime()
                : prefix + DateUtil.keywordDate();
    }

    public static boolean isZero(BigDecimal value) {
        return value != null && value.compareTo(BigDecimal.ZERO) == 0;
    }

}
