package com.personal.knowledge.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtil {
    
    public static String generateString(int length) {

        return RandomStringUtils.randomAlphanumeric(length);
    }
}