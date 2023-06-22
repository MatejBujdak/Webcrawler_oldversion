import java.util.ArrayList;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Main {

    public static void main(String[] args) {
        String url = "https://en.wikipedia.org/";
        Connection con = Jsoup.connect(url);
        crawl(1, url, new ArrayList<String>());
    }

    private static void crawl(int level, String url, ArrayList<String> visited){
        if(level <= 5){
            Document doc = request(url, visited);

            if(doc != null){
                for(Element link: doc.select("a[href]")){
                    String next_link = link.absUrl("href");
                    if(visited.contains(next_link) == false){
                        crawl(level++, next_link, visited);
                    }
                }
            }

        }
    }

    private static Document request(String url, ArrayList<String> v){
        try{
            Connection con = Jsoup.connect(url);
            Document doc = con.get();

            if(con.response().statusMessage().equals("OK")){
                System.out.println("Link: " + url);
                System.out.println(doc.text());
                v.add(url);

                return doc;
            }
            return null;
        }
        catch (IOException e){
            return null;
        }

    }

}
