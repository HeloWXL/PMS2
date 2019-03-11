package com.pms2.yushuting.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangxl
 * @date 2019/3/11
 */
public class Test {
//    public static void main(String[] args) {
//        System.out.println(new Date());
//    }


    public static int compare_date(String DATE1) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = new Date();
            Date dt2 = df.parse(DATE1);
            System.out.println(dt1.getDate());
            System.out.println(dt2.getDate());
            if (dt1.getDate() <= dt2.getDate() && dt2.getDate()<dt1.getDate()+1) {
                return 1;
            } else{
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
