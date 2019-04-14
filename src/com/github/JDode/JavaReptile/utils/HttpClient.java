package com.github.JDode.JavaReptile.utils;

import com.github.kevinsawicki.http.HttpRequest;

import java.util.Map;

/**
 * Created by Ding on 2019/4/13 2:13 PM.
 *
 * @Description: 自己封装的http请求工具类
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
public class HttpClient {

    private String url;


    public HttpClient init(String url){
        this.url = url;
        return this;
    }


    public String get(){
        return HttpRequest.get(this.url).body();
    }

    public static String get(String url){
        return HttpRequest.get(url).body();
    }

    public String get(Map<String,Object> param){
        return HttpRequest.get(this.url).form(param).body();
    }

    public static String get(String url,Map<String,Object> param){
        return HttpRequest.get(url).form(param).body();
    }

    public String post(Map<String,Object> param){
        return HttpRequest.post(this.url).form(param).body();
    }

    public static String post(String url,Map<String,Object> param){
        return HttpRequest.post(url).form(param).body();
    }

}
