package Jsoup_crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Crawler {

    //metoda na prehladavanie podstranok
<<<<<<< Updated upstream
    public void crawl(long deep, String url, ArrayList<String> visited) {
=======
    public static ArrayList<Document> crawl(int deep, String url, ArrayList<String> visited) {
        ArrayList<Document> documents = new ArrayList<>();
>>>>>>> Stashed changes
        Stack<Caller> stack = new Stack<>();
        deep *= -1;
        System.out.println("HLBA JE: " + deep);
        stack.push(new Caller(deep, url));

        try{
        DetectorFactory.loadProfile("src/main/profiles");
        } catch (LangDetectException e) {
            e.printStackTrace();
        }

        while (!stack.isEmpty()) {
            Caller frame = stack.pop();
            deep = frame.getDeep();
            url = frame.getUrl();

            Document doc = request(url, visited);

<<<<<<< Updated upstream
                if (doc != null && deep <= -1) {
                    for (Element link : doc.select("a[href]")) {
                        String next_link = link.absUrl("href");
                        if (!visited.contains(next_link)) {
                            stack.push(new Caller(deep++, next_link));
                        }
=======
            if (doc != null && deep <= 2) {
                documents.add(doc);

                for (Element link : doc.select("a[href]")) {
                    String next_link = link.absUrl("href");
                    if (!visited.contains(next_link)) {
                        stack.push(new Caller(deep + 1, next_link));
>>>>>>> Stashed changes
                    }
                }
            }
        }

        return documents;
    }

    private static Document request(String url, ArrayList<String> v) {
        try {
            Connection con = Jsoup.connect(url);
            Document doc = con.get();

<<<<<<< Updated upstream
            if(con.response().statusMessage().equals("OK")){

                //vypis obsahu stranky
                Output.text_output(doc, url);

                //prida medzi skontrolovane stranky

=======
            if (con.response().statusMessage().equals("OK")) {
>>>>>>> Stashed changes
                v.add(url);
                return doc;
            }
            return null;
        } catch (IOException e) {
            return null;
        }catch (IllegalArgumentException e) {
            return null;
        }
    }


}

