package com.xuanzjie.filemanage.utils;

/**
 * @Author: xuan
 * @Date: 2019/12/30 10:56
 * @Description:
 */
public class StringUtils {

    public static Boolean isEmpty(String string) {
        if (string.isEmpty() || string.length() <= 0) {
            return false;
        }
        return true;
    }

}
