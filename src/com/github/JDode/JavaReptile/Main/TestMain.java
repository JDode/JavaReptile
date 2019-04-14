package com.github.JDode.JavaReptile.Main;

import com.github.JDode.JavaReptile.utils.HttpClient;

public class TestMain {

	public static void main(String[] args) {
		System.out.println(HttpClient.get("http://mnks.jxedt.com/get_question?r=0.04581873948117421&index=538").replaceAll("/", "//").replaceAll("\\\\", "\\\\\\\\"));

	}

}
