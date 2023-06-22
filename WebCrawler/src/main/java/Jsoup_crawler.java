import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Jsoup_crawler {

    public static void crawl(int level, String url, ArrayList<String> visited) {
        Stack<Caller> stack = new Stack<>();
        stack.push(new Caller(level, url));

        while (!stack.isEmpty()) {
            Caller frame = stack.pop();
            level = frame.level;
            url = frame.url;

            if (level <= 1) {
                Document doc = request(url, visited);

                if (doc != null) {
                    for (Element link : doc.select("a[href]")) {
                        String next_link = link.absUrl("href");
                        if (!visited.contains(next_link)) {
                            stack.push(new Caller(level++, next_link));
                        }
                    }
                }
            }
        }
    }

    private static class Caller {
        private int level;
        private String url;

        public Caller(int level, String url) {
            this.level = level;
            this.url = url;
        }
    }

    private static Document request(String url, ArrayList<String> v){
        try{
            Connection con = Jsoup.connect(url);
            Document doc = con.get();

            if(con.response().statusMessage().equals("OK")){
                System.out.println("Link danej stranky: " + url);
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
