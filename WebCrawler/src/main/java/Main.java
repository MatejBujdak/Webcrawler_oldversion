import Jsoup_crawler.Crawler;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Crawler crawler = new Crawler();
        ArrayList<String> url_list = new ArrayList<>();
        url_list.add("https://sk.wikipedia.org/wiki/Po%C4%8D%C3%ADta%C4%8D");
        long deep = 0;

        for(String url: url_list) {
            Crawler.crawl(deep, url, new ArrayList<>());
        }
    }



}
