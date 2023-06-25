package Jsoup_crawler;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//trieda na ukladanie ano
class Caller {
    private int deep;
    private String url;

    public Caller(int deep, String url) {
        this.deep = deep;
        this.url = url;
    }

    public int deep(){
        return this.deep;
    }

    public String url(){
        return this.url;
    }


}
