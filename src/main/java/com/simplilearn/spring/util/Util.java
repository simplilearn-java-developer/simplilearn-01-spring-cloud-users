package com.simplilearn.spring.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String formatDate(Date date) {

        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
