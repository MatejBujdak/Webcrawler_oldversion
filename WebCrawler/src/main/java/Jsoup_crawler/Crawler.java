package Jsoup_crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Crawler {

    //metoda na prehladavanie podstranok
    public void crawl(int deep, String url, ArrayList<String> visited) {
        Stack<Caller> stack = new Stack<>();
        stack.push(new Caller(deep, url));

        while (!stack.isEmpty()) {
            Caller frame = stack.pop();
            deep = frame.deep();
            url = frame.url();

            Document doc = request(url, visited);


                if (doc != null && deep <= 2) {
                    for (Element link : doc.select("a[href]")) {
                        String next_link = link.absUrl("href");
                        if (!visited.contains(next_link)) {
                            stack.push(new Caller(deep++, next_link));
                        }
                    }
                }
        }
    }

    //metoda na overenie, či stránku ide otvoriť
    private Document request(String url, ArrayList<String> v){
        try{
            Connection con = Jsoup.connect(url);
            Document doc = con.get();

            if(con.response().statusMessage().equals("OK")){

                System.out.println("URL: " + url);

                //vypis obsahu stranky
                Output.text_output(doc);

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

