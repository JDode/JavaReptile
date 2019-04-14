package com.github.JDode.JavaReptile.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class JDBCUtilTest {

    @Test
    public void init() {
        JDBCUtil init = JDBCUtil.init("/Users/jdode/Documents/JavaProjects/idea_work/JavaReptile/src/config/jdbc.properties");

    }

    @Test
    public void closeConnection() {
    }
}
