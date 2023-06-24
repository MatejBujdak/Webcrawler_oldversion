import java.util.ArrayList;

import Jsoup_crawler.Crawler;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> url_list = new ArrayList<>();
        Crawler crawler = new Crawler();
        url_list.add("https://sk.wikipedia.org/wiki/Po%C4%8D%C3%ADta%C4%8D");

        for(String url: url_list) {
            crawler.crawl(1, url, new ArrayList<>());
        }
    }



}
