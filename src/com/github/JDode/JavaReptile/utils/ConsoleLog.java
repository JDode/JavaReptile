package com.github.JDode.JavaReptile.utils;

import java.util.Date;

/**
 * Created by Ding on 2019/4/13 3:06 PM.
 *
 * @Description: 控制台log输出
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
public class ConsoleLog {

    public static void info(String message){
        System.out.println(new Date()+":==>"+message);
    }

    public static void error(String message){
        System.err.println(new Date()+":==>"+message);
    }

}
