import java.util.ArrayList;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.Stack;


public class Main {

    public static void main(String[] args) {
        ArrayList<String> url_list = new ArrayList<>();
        Jsoup_crawler crawler = new Jsoup_crawler();
        url_list.add("https://en.wikipedia.org/wiki/Main_Page");



        for(String url: url_list) {
            Connection con = Jsoup.connect(url);
            crawler.crawl(1, url, new ArrayList<String>());
        }
    }



}
