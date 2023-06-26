import java.util.ArrayList;

import Jsoup_crawler.Crawler;

public class Main {

    public static void main(String[] args) {

        Crawler crawler = new Crawler();

        //////VSTUP//////

        //List s url odkazmi na stranky ktore chceme prehladat
        ArrayList<String> url_list = new ArrayList<>();

        url_list.add("https://sk.wikipedia.org/wiki/Po%C4%8D%C3%ADta%C4%8D");

        //hlbka ponoru do ktorej chceme prehladavat stranky
        long deep = 0;

        //////VSTUP//////

        for(String url: url_list) {
            crawler.crawl(deep, url, new ArrayList<>());
        }
    }



}
